import com.safecabs.endpoint.RideService;
import com.safecabs.endpoint.UserService;
import com.safecabs.endpoint.impl.RideServiceImpl;
import com.safecabs.endpoint.impl.UserServiceImpl;
import com.safecabs.model.Gender;
import com.safecabs.model.RideRequest;
import com.safecabs.model.User;
import com.safecabs.mutex.RideMutex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

public class SafeCabTest {

    private UserService userService;
    private RideService rideService;


    @Before
    public void setUp() {
        userService = UserServiceImpl.getInstance();
        rideService = RideServiceImpl.getInstance();
    }

    @AfterTestClass
    public void tearDown() {
        rideService.shutDown();
        userService = null;
        rideService = null;
    }

    @Test(expected = RuntimeException.class)
    public void testBookRideWithNotRegisteredUser() {
        User user = new User("NntRegisteredUser", "mb", Gender.MALE);
        rideService.requestRide(new RideRequest(user, "Destination"));
    }


    @Test
    public void testCaseWith10Users() {
        //Create Test users
        List<User> testUsers = getTestUsers10();

        //Registering User
        registerTestUsers(testUsers);

        //Requesting for Ride
        requestRideForTestUsers(testUsers);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkIfUnsafeJourney();
    }


    @Test
    public void testCaseWith100Users() {
        //Create Test users
        List<User> testUsers = getTestUsers100();

        //Registering User
        registerTestUsers(testUsers);

        //Requesting for Ride
        requestRideForTestUsers(testUsers);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkIfUnsafeJourney();
    }

    private void checkIfUnsafeJourney() {
        /*Checking the completed Rides passenger History to check if there any unsafe combination*/
        RideMutex rideMutex = (RideMutex) ReflectionTestUtils.getField(rideService, "rideMutex");
        rideMutex.getCabs().forEach(c -> {

            c.getRideHistory().keySet().forEach(k -> {
                List<User> passengers = c.getRideHistory().get(k);
                long femaleCount = passengers.stream().filter(u -> u.getGender().equals(Gender.FEMALE)).count();
                long maleCount = passengers.stream().filter(u -> u.getGender().equals(Gender.MALE)).count();
                Assert.assertTrue((femaleCount == 4 && maleCount == 0)
                        || (femaleCount == 0 && maleCount == 4)
                        || (femaleCount == 2 && maleCount == 2)
                        || (femaleCount == 0 && maleCount == 0));
            });

        });
    }


    private static List<User> getTestUsers100() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Gender gender = Gender.getRandom();
            users.add(new User(gender + "-" + i, "mob" + i, gender));
        }
        return users;
    }

    private static List<User> getTestUsers10() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Gender gender = Gender.getRandom();
            users.add(new User(gender + "-" + i, "mob" + i, gender));
        }
        return users;
    }

    private void registerTestUsers(List<User> users) {
        users.forEach(userService::registerUser);
    }

    private void requestRideForTestUsers(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            rideService.requestRide(new RideRequest(users.get(i), "Destination " + i));
        }
    }

}
