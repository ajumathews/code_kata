package servicediscovery;

import com.netflix.appinfo.CloudInstanceConfig;
import com.netflix.config.ConfigurationManager;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;
import feign.Feign;
import feign.Service;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.ribbon.LoadBalancingTarget;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class ServiceDiscoveryManager {



    /**
     * Constructor to load eureka properties from resouces folder.
     *
     * @param filePath
     */
    public ServiceDiscoveryManager(String filePath) {
        try {
            ConfigurationManager.loadPropertiesFromResources(filePath);
        } catch (IOException exception) {

        }
        DiscoveryManager.getInstance().initComponent(new CloudInstanceConfig(), new DefaultEurekaClientConfig());
    }

    public Service getClient(final Class serviceClass, final String serviceIdentifier) {
        final String serviceUrl = "http://" + serviceIdentifier;
        Service service = (Service) Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(new OkHttpClient())
                .target(LoadBalancingTarget.create(serviceClass, serviceUrl));


        return service;
    }
}
