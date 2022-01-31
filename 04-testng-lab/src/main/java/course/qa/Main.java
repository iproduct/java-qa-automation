package course.qa;

import course.qa.dao.*;
import course.qa.model.*;
import course.qa.util.PublicationInputUtil;
import course.qa.view.PublicationsView;

import java.util.List;
import java.util.Set;

public class Main {
    public static final List<Publication> PUBLICATIONS = List.of(
            new Book("Head First Java", "A Brain-Friendly Guide", "Kathy Sierra, Bert Bates",
                    2008, "O'Reilly", "0596009208",
                    Set.of("java", "introduction", "programming"), CoverType.PAPER_BACK, 720,
                    "Between Moore's law and the notion of \"Internet time,\" we're constantly " +
                            "being bombarded with more and more information--most of it in the form of disorganized " +
                            "data. Turning this information into useful knowledge is getting harder and harder to do," +
                            " and it takes time that we just don't have. The current economic situation hasn't " +
                            "helped either. With money spread thin, who hasn't had to take on new tasks and learn " +
                            "new things? And slashed training budgets mean there's little to rely on for learning " +
                            "except books- but learning a complex new programming language like Java from a book is " +
                            "no simple task. Maybe your boss is giving you two weeks to come up to speed for a " +
                            "project, or maybe you're ready to take that next step up in your current job, or be a " +
                            "more viable candidate for anewjob."),
            new Book("Effective Java", "2nd Edition", "Joshua Bloch",
                    2008, "Addison-Wesley", "0321356683",
                    Set.of("java", "advanced", "programming"), CoverType.PAPER_BACK, 346,
                    "Are you looking for a deeper understanding of the Java™ programming language so that " +
                            "you can write code that is clearer, more correct, more robust, and more reusable? Look " +
                            "no further! Effective Java™, Second Edition, brings together seventy-eight " +
                            "indispensable programmer’s rules of thumb: working, best-practice solutions for the " +
                            "programming challenges you encounter every day. This highly anticipated new edition " +
                            "of the classic, Jolt Award-winning work has been thoroughly updated to cover Java SE 5 " +
                            "and Java SE 6 features introduced since the first edition. Bloch explores new design " +
                            "patterns and language idioms, showing you how to make the most of features ranging " +
                            "from generics to enums, annotations to autoboxing. Each chapter in the book consists " +
                            "of several “items” presented in the form of a short, standalone essay that provides " +
                            "specific advice, insight into Java platform subtleties, and outstanding code examples. " +
                            "The comprehensive descriptions and explanations for each item illuminate what to do, " +
                            "what not to do, and why. Highlights include: New coverage of generics, enums, " +
                            "annotations, autoboxing, the for-each loop, varargs, concurrency utilities, and " +
                            "much more Updated techniques and best practices on classic topics, including objects, " +
                            "classes, libraries, methods, and serialization How to avoid the traps and pitfalls of " +
                            "commonly misunderstood subtleties of the language Focus on the language and its most " +
                            "fundamental libraries: java.lang, java.util, and, to a lesser extent, " +
                            "java.util.concurrent and java.io Simply put, Effective Java™, Second Edition, " +
                            "presents the most practical, authoritative guidelines available for writing efficient, " +
                            "well-designed programs."),
            new Paper("Synthesizing Information Systems", "the APIS Project",
                    "Benoît Fraikin, Frederic Gervais, R. Laleau", 2007,
                    "IEEE", "IEEE TENCON",
                    "This article presents the main features of the APIS project that addresses " +
                            "the rapid development of informationsystems from formal speciﬁcations. " +
                            "Information systems arespeciﬁed using a trace-based formal language. " +
                            "The se-quences of input events accepted by the system are describedwith a " +
                            "process algebra; they represent the valid traces of theinformation system. " +
                            "Entity types, associations and attributesare described using a class diagram and " +
                            "computed by meansof recursive functions deﬁned on the valid traces of the system." +
                            "In the APIS framework, three tools have been developed." +
                            "Java program that executes a relationaldatabase transaction. " +
                            "The synthesized transactions implementthe speciﬁcation of the information system’s " +
                            "data structure andare used by the interpreter to update or query the database." +
                            "The article also brings out the main future developments of theproject.", ""),
            new Paper("J2EE framework perspective for security augmentation", "", "Pawan Kumar Verma", 2009,
                    "IEEE", "IEEE TENCON", "", "pp.1-10")
            );

    public static void main(String[] args) {
        // users
        Repository<Long, User> userRepo = new RepositoryHashMapImpl<>(new LongSequenceGenerator());
        userRepo.create(new User("Trayan", 45, "trayan", "trayan123"));
        User georgi = userRepo.create(new User("Georgi", 35, "george", "george123"));
        User maria = userRepo.create(new User("Maria", 25, "mary", "mary123",
                new Role[]{Role.CLIENT, Role.ISSUER, Role.ADMIN}));

        userRepo.deleteById(georgi.getId());
        maria.setPassword("newpass789");
        userRepo.update(maria);

        for (User p : userRepo.findAll()) {
            System.out.println(p);
        }

        // publications
        PersistentRepository<Long, Publication> publicationRepo = new PersistentRepositoryFileImpl<>(new LongSequenceGenerator());
//        for (Publication pub: PUBLICATIONS ) {
//            publicationRepo.create(pub);
//        }

        publicationRepo.load();

        PublicationsView pView = new PublicationsView();
        pView.printPublications(publicationRepo.findAll());

        // test PublicationInputUtil
        System.out.println();
        Publication pub = PublicationInputUtil.inputNewPublication();
        System.out.println(pub.format());
        publicationRepo.create(pub);

        publicationRepo.save();

    }
}
