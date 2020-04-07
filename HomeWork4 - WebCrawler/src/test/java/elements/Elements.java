package elements;

public class Elements {
    public static final String SYSTEM_URL = "https://www.mann-ivanov-ferber.ru/books/allbooks/?booktype=audiobook"; //Адрес ресурса
    public static final String BUTTON_LOADER = "//div[contains(@class, 'js-page-loader')]"; //Кнопка загрузки книг
    public static final String BOOK = "a.lego-book__cover.js-image-block"; //Книга на странице
    public static final String TITLE_BOOK = "//h1[contains(@class, 'p-sky-title')]"; //Название книги на странице книги
    public static final String AUTHOR_BOOK = "//span[contains(@class, 'author active')]"; //Автор книги на странице книги
    public static final String PRICE_EBOOK = "//div[contains(@class, 'js-gtm-type-toggle') and contains(@data-type, 'e-book')]"; //Цена электронной книги на странице книги
    public static final String LINK_DOWNLOAD_TRIAL_FRAGMENT = "//a[contains(@class, 'nkk-file-download__link')]"; //Ссылка на ознакомительный фрагмент на странице книги

}
