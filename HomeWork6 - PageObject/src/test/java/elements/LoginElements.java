package elements;

public class LoginElements {

    //Главная
    public static final String TITTLE_LOGIN_PAGE  = "//span[contains(text(), 'Войдите в свой аккаунт')]"; //Страница входа в аккаунт
    public static final String TITTLE_LK_PAGE  = "//h1[contains(@class, 'title__text') and contains(text(), 'Личный кабинет')]"; //Страница личного кабинета
    public static final String BANNER = "div.sticky-banner__close.js-sticky-banner-close"; //Закрытие баннера
    public static final String OPEN_LOGIN = "//button[contains(@class, 'header2__auth js-open-modal')]"; //Кнопка "Вход и регистрация"
    public static final String INPUT_LOGIN = "//input[contains(@class, 'js-email-input')]"; //Поле для ввода электронной почты
    public static final String INPUT_PASSWORD = "//input[contains(@class, 'js-psw-input')]"; //Поля для ввода пароля
    public static final String SUBMIT_LOGIN_PAGE = "//button[contains(@class, 'new-button_md')]"; //Кнопка "Войти"
    public static final String LK = "//p[contains(@class, 'header2-menu__item-text__username')]"; //Ссылка "Личный кабинет" (отображается имя пользователя)
    public static final String MY_PROFILE = "//b[contains(@class, 'header2-menu__dropdown-text_name')]"; //Ссылка "Мой профиль"

}
