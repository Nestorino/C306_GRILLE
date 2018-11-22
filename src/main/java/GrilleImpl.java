/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nestor
 */
public class GrilleImpl implements Grille {

    /**
     *
     * L'attribut.
     */
    private final char[][] GRILLE;

    /**
     *
     * @param laGrille Le paramètre de la fonction
     */
    public GrilleImpl(final char[][] laGrille) {
        this.GRILLE = laGrille;
    }

    @Override
    public final int getDimension() {
        return this.GRILLE.length;
    }

    @Override
    public void setValue(int x, int y, char value)
            throws IllegalArgumentException {
        String illegalArgMsg = "Valeur interdite aux vues des autres"
                + " valeurs de la grille";
        if (this.possible(x, y, value)) {
//      Parcourir la ligne x et véfifier si la valeur existe déjà.             
            for (int j = 0; j < this.getDimension(); j++) {
                if (this.GRILLE[x][j] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }
        }
//      Parcourir la colonne y et véfifier si la valeur existe déjà             
        for (int i = 0; i < this.getDimension(); i++) {
            if (this.GRILLE[i][y] == value) {
                throw new IllegalArgumentException(illegalArgMsg);
            }
        }
//      Parcourir la box et véfifier si la valeur existe déjà. 
//      tailleBloc = 3 ou 4 selon la dimension du jeu             
        int tailleBloc = (int) Math.sqrt(this.getDimension());
        int i = (x / tailleBloc) * tailleBloc;
        int j = (y / tailleBloc) * tailleBloc;

        for (int r = 0; r < tailleBloc; r++) {
            for (int c = 0; c < tailleBloc; c++) {
                if (this.GRILLE[i + r][j + c] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }
        }
//      A donc passé tous les controles avec succès.             
        this.GRILLE[x][y] = value;
    }

    @Override
    public final char getValue(int x, int y) throws IllegalArgumentException {
//      si x ou y sont hors bornes (0-8).         
        if (x < 0 || x >= this.getDimension() || y < 0 || y >= this.getDimension()) {
            throw new IllegalArgumentException("Ligne ou colonne hors borne");
        }
        return this.GRILLE[x][y];
    }

    @Override
    public final boolean complete() {
//      Parcourir les lignes et colonnes et véfifier s'y a au moins 
//      une veleur EMPTY c'est à dire vide.         
        for (int x = 0; x < this.getDimension(); x++) {
            for (int y = 0; y < this.getDimension(); y++) {
                if (this.GRILLE[x][y] == Grille.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public final boolean possible(int x, int y, char value)
            throws IllegalArgumentException {
//si x ou y sont hors bornes (0-8).         
        if (x < 0 || x >= this.getDimension()
                || y < 0 || y >= this.getDimension()) {
            throw new IllegalArgumentException("Ligne ou colonne hors borne");
        }
//      S'assurer que la valeur n'est pas interdite         
        for (int i = 0; i < this.getDimension(); i++) {
            if (value == POSSIBLE[i]) {
                return true;
            }
        }
        return false;
    }

}
