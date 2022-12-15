package conditional.daps.cosmos;

import conditional.daps.core.IDocumentRepository;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(CosmosEnabledCondition.class)
public class DocumentRepository implements IDocumentRepository {

    @Override
    public void create() {
        System.out.println("In Cosmos create");
    }
}
