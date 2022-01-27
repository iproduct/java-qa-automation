package course.qa.view;

import course.qa.model.Publication;

import java.util.Collection;

public class PublicationsView {
    public void printPublications(Collection<Publication> publications) {
        for(Publication p : publications) {
            System.out.println(p.format());
        }
    }
}
