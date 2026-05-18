public class Magatzem {
    Article[] articles;

    private static final String FORMATGE = "Formatge Gidurat";
    private static final String MARTELL  = "Martell de Thor (Llegendari)";
    private static final String ENTRADES = "Entrades per al Concert del Trobador";

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (Article article : articles) {
            actualitzarArticle(article);
        }
    }

    private void actualitzarArticle(Article a) {
        if (a.nom.equals(MARTELL)) return;

        if (a.nom.equals(FORMATGE)) {
            actualitzarFormatge(a);
        } else if (a.nom.equals(ENTRADES)) {
            actualitzarEntrades(a);
        } else {
            actualitzarNormal(a);
        }

        a.diesPerVendre--;
    }

    private void actualitzarNormal(Article a) {
        if (a.qualitat > 0) a.qualitat--;
        if (a.diesPerVendre <= 0 && a.qualitat > 0) a.qualitat--;
    }

    private void actualitzarFormatge(Article a) {
        if (a.qualitat < 50) a.qualitat++;
        if (a.diesPerVendre <= 0 && a.qualitat < 50) a.qualitat++;
    }

    private void actualitzarEntrades(Article a) {
        if (a.diesPerVendre <= 0) { a.qualitat = 0; return; }
        if (a.qualitat < 50) a.qualitat++;
        if (a.diesPerVendre <= 10 && a.qualitat < 50) a.qualitat++;
        if (a.diesPerVendre <= 5  && a.qualitat < 50) a.qualitat++;
    }
}