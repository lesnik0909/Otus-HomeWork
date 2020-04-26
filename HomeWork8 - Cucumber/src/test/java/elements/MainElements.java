package elements;

public class MainElements {

    public static final String BANNER = "div.sticky-banner__close.js-sticky-banner-close"; //Кнопка закрытия банера
    public static final String CHOOSE_COURSE = "//div[contains(text(), 'Выбрать курс')]"; //Кнопка "Выбрать курс"
    public static final String OPEN_LOGIN = "//button[contains(@class, 'header2__auth js-open-modal')]"; //Кнопка "Вход и регистрация"
    public static final String INPUT_LOGIN = "//input[contains(@class, 'js-email-input')]"; //Поле для ввода электронной почты
    public static final String INPUT_PASSWORD = "//input[contains(@class, 'js-psw-input')]"; //Поля для ввода пароля
    public static final String SUBMIT_LOGIN_PAGE = "//button[contains(@class, 'new-button_md')]"; //Кнопка "Войти"
    public static final String ERROR_MESSAGE = "//div[contains(text(), 'Такая пара логин/пароль не существует')]"; //Сообщение об ошибке при входе в личный кабинет
    public static final String TESTING = "//a[contains (@class, 'course-categories__nav-item') and contains(@title, 'Тестирование')]"; //Вкладка "Тестирование"
    public static final String HOME_PAGE = "//a[contains(@class, 'header2__logo-img')]"; //Логотип, возвращающий на главную страницу
    public static final String HEADER_PAGE_LOGIN = "//span[contains (text(), 'Войдите в свой аккаунт')]"; //Заголовок на странице входа в личный кабинет
    public static final String CLOSE_PAGE_LOGIN = "//div[contains(@class, 'new-log-reg__close js-close-modal')]"; //Кнопка закрытия страницы входа в личный кабинет
}
