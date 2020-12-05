package pdl.wiki;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.Normalizer;
import java.util.List;

/**
 * Classe qui récupère le titre de la page et le nettoie
 */
public class Page
{
    private String title;
    private List<List<String>> csvListHtml;
    private List<List<String>> csvListWikitext;
    private Url url;

    public Page(Url url)
    {
        this.url = url;
        // Récupération du titre
        this.title = purifyTitle();
    }


    /**
     * Permet de r�cuperer l'url sur lequel nous travaillons
     *
     * @return retourne l'url sur lequel nous travaillons
     */
    public Url getUrl()
    {
        return url;

    }

    /**
     * Permet de r�cuperer le titre de la page sur laquelle nous travaillons
     *
     * @return retourne le titre de la page sur laquelle nous travaillons
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Permet d'ajouter la liste de csv généré par HTMLExtractor
     *
     * @param csvListHtml
     */
    public void setCsvListHtml(List<List<String>> csvListHtml)
    {
        this.csvListHtml = csvListHtml;
    }

    /**
     * Permet d'ajouter la liste de csv généré par WikiTextExtractor
     *
     * @param csvListWikitext
     */
    public void setCsvListWikitext(List<List<String>> csvListWikitext)
    {
        this.csvListWikitext = csvListWikitext;
    }

    /**
     * Permet de connaitre la liste des �l�ments contenu dans le fichier csv
     *
     * @return retourne une liste des diff�rents �l�ments contenu dans le fichier csv généré par le HTMLExtractor
     */
    public List<List<String>> getCsvListHtml()
    {
        return csvListHtml;
    }

    /**
     * Permet de connaitre la liste des �l�ments contenu dans le fichier csv
     *
     * @return retourne un tableau des diff�rents �l�ments contenu dans le fichier csv généré par le WikiTextExtractor
     */
    public List<List<String>> getCsvListWikitext()
    {
        return csvListWikitext;
    }

    /**
     * Permet de récupérer le titre de la page dans un format condensé
     *
     * @return le titre de la page sans accent et espace
     */
    public String getTitleWithoutSpace()
    {
        String titleWithoutSpace = "";
        for (String mot : title.split("\\s"))
        {
            String temp = mot.replaceAll("'", "");
            titleWithoutSpace += temp.substring(0, 1).toUpperCase() + temp.substring(1);
        }
        // On remplace les accents par leurs lettres respectives
        titleWithoutSpace = Normalizer.normalize(titleWithoutSpace, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return titleWithoutSpace;
    }

    /**
     * Permet de clarifier le titre des tableaux
     *
     * @return le titre sans les paramètres de l'url
     */
    private String purifyTitle()
    {
    	String pageName = url.getPageName();
    	
        return pageName.replaceAll("_", " ");
    }

}
