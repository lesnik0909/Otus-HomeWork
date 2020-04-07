package elements;

public class Elements {

    public static final String PRELOADER = "//div[contains(@class, 'preloadable__preloader_visibility_visible')]"; //Предзагрузчик

    //Главная
    public static final String YANDEX_MARKET_URL = "https://market.yandex.ru"; //Ссылка Яндекс Маркет
    public static final String CATEGORIES = "//button[contains(@id, '27903767-tab')]"; //Кнопка "Категории"
    public static final String ELECTRONICS = "//*[@id=\"39889743-tab\"]/a"; //Ссылка "Электроника"
    public static final String SMARTPHONES = "//a[contains(text(), 'Мобильные телефоны')]"; //Ссылка "Мобильные телефоны"

    //Раздел "Мобильные телефоны"
    public static final String TITLE_ITEM = "//div[./a[contains(@title, '"; //Название товара
    public static final String ADD_COMPARE = "/div/div/div/div[contains(@class, 'n-user-lists_type_compare_in-list_no')]"; // Кнопка "Добавить в сравнение"
    public static final String POPUR_INFORMER = "//div[contains(@class, 'popup-informer')]"; //Всплывающее сообщение при добавлении товара в сравнение
    public static final String POPUR_INFORMER_TITLE = "//div[contains(@class,'popup-informer__title') and contains(text(), '";
    public static final String COMPARE = "//a[contains(@class, 'item_type_compare')]"; //Кнопка "Сравнить"

    //Фильтры
    public static final String SHOW_ALL = "//button[contains(text(), 'Показать всё')]"; //Фильтр "Показать все"
    public static final String SEARCH = "//*[@id=\"7893318-suggester\"]"; //Фильтр ввод модели
    public static final String PRISE = "//a[contains(text(),'по цене')]"; //Фильтр сортировать "по цене"

    //Страница сравнения товара
    public static final String ALL_CHARACTERISTICS = "//span[contains(text(), 'все характеристики')]"; //Кнопка "Все характеристики"
    public static final String DEFFERENT_CHARACTERISTICS = "//span[contains(text(), 'различающиеся характеристики')]"; //Кнопка "Различающиеся характеристики"
    public static final String OPERATIONG_SYSTEM = "//div[contains(@class, 'n-compare-row-name')]"; //Параметр "Операционная система" в характеристиках
    public static final String ITEMS_COMPARE = "//div[contains(@class, 'n-compare-cell-draggable')]"; //Товар на странице сравнения товаров

}
