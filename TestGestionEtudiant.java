public class TestGestionEtudiant {
    
    public static void main(String[] args) {
        // Initialisation de la liste d'étudiants
        GestionEtudiant gestionEtudiant = new GestionEtudiant();
        
        // Affichage de la liste d'étudiants
        System.out.println("Liste d'étudiants initiale :");
        for (Etudiant etudiant : gestionEtudiant.getEtudiants()) {
            System.out.println(etudiant);
        }
        System.out.println();
        
        // Recherche d'un étudiant par son CIN
        System.out.println("Recherche d'un étudiant par son CIN :");
        Etudiant etudiantRecherche = gestionEtudiant.getEtudiantByCin(3);
        System.out.println(etudiantRecherche);
        System.out.println();
        
        // Ajout d'un nouvel étudiant
        System.out.println("Ajout d'un nouvel étudiant :");
        Etudiant nouvelEtudiant = new Etudiant(5, "Doe", "John", "5 rue des Lilas");
        boolean ajout = gestionEtudiant.addEtudiant(nouvelEtudiant);
        if (ajout) {
            System.out.println("L'étudiant a été ajouté avec succès.");
        } else {
            System.out.println("Impossible d'ajouter l'étudiant : un étudiant avec le même CIN existe déjà.");
        }
        System.out.println();
        
        // Affichage de la liste d'étudiants après ajout
        System.out.println("Liste d'étudiants après ajout :");
        for (Etudiant etudiant : gestionEtudiant.getEtudiants()) {
            System.out.println(etudiant);
        }
        System.out.println();
        
        // Mise à jour d'un étudiant existant
        System.out.println("Mise à jour d'un étudiant existant :");
        Etudiant etudiantAModifier = gestionEtudiant.getEtudiantByCin(1);
        
        boolean miseAJour = gestionEtudiant.updateEtudiant(etudiantAModifier);
        if (miseAJour) {
            System.out.println("L'étudiant a été mis à jour avec succès.");
        } else {
            System.out.println("Impossible de mettre à jour l'étudiant : l'étudiant n'existe pas dans la liste.");
        }
        System.out.println();
        
        // Affichage de la liste d'étudiants après mise à jour
        System.out.println("Liste d'étudiants après mise à jour :");
        for (Etudiant etudiant : gestionEtudiant.getEtudiants()) {
            System.out.println(etudiant);
        }
        System.out.println();
        
        // Suppression d'un étudiant
        System.out.println("Suppression d'un étudiant :");
        boolean suppression = gestionEtudiant.deleteEtudiant(2);
        if (suppression) {
            System.out.println("L'étudiant a été supprimé avec succès.");
        } else {
            System.out.println("Impossible de supprimer l'étudiant : l'étudiant n'existe pas dans la liste.");
        }
        System.out.println();
        
        // Affichage de la liste d'étudiants après suppression
        System.out.println("Liste d'étudiants après suppression :");
        for (Etudiant etudiant : gestionEtudiant.getEtudiants()) {
            System.out.println(etudiant);
        }
        System.out.println();
    }
    
}

