package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;
import personnages.Gaulois;

class ControlEmmenagerTest {

    private Village village;
    private Chef abraracourcix;

    @BeforeEach
    public void initialiserSituation() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);
        
    }

    @Test
    void testControlEmmenager() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        assertNotNull(controlEmmenager, "Le constructeur ne doit pas renvoyer null");
    }

    @Test
    void testIsHabitant() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        // Ajout d'un Gaulois "Bonemine" et vérification de sa présence
        controlEmmenager.ajouterGaulois("Bonemine", 10);
        assertTrue(controlEmmenager.isHabitant("Bonemine"), "Bonemine doit être un habitant");

        // Vérification qu'un nom inexistant n'est pas reconnu comme habitant
        assertFalse(controlEmmenager.isHabitant("Existe pas"), "Un habitant inexistant ne doit pas être reconnu");

        // Ajout d'un Druide "Panoramix" et vérification de sa présence
        controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
        assertTrue(controlEmmenager.isHabitant("Panoramix"), "Panoramix doit être un habitant après ajout");
    }

    @Test
    void testAjouterDruide() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        // Avant l'ajout, "Panoramix" ne doit pas être présent
        assertFalse(controlEmmenager.isHabitant("Panoramix"), "Panoramix ne doit pas être un habitant initialement");
        // Ajout du druide
        controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
        // Vérification de la présence après ajout
        assertTrue(controlEmmenager.isHabitant("Panoramix"), "Panoramix doit être un habitant après ajout");
        assertFalse(controlEmmenager.isHabitant("Colar"));
    }

    @Test
    void testAjouterGaulois() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        // Vérification qu'un Gaulois inexistant, ici "Obelix", n'est pas présent
        assertFalse(controlEmmenager.isHabitant("Obelix"), "Obelix ne doit pas être un habitant initialement");
        // Ajout du Gaulois
        controlEmmenager.ajouterGaulois("Obelix", 20);
        // Vérification de la présence après ajout
        assertTrue(controlEmmenager.isHabitant("Obelix"), "Obelix doit être un habitant après ajout");
    }
}
