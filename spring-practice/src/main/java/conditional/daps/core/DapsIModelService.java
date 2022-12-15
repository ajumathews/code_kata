package conditional.daps.core;

import javax.inject.Inject;
import javax.inject.Named;


@Named("dapsIModelService")
public class DapsIModelService implements IModelService {

    @Inject
    private IDocumentRepository documentRepository;

    @Override
    public void process() {
        System.out.println("In DapsIModelService");
        documentRepository.create();
    }
}
