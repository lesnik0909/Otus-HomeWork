package elements;

public class MainElements {

        public static final String SERVICES_HABR = "//span[contains(@class, 'projects-dropdown')]"; //Сервисы Habr
        public static final String HABR = "//p[contains(text(), 'Сообщества IT-специалистов')]"; //Сервис Habr
        public static final String Q_AND_A = "//p[contains(text(), 'Ответы на')]"; //Сервис Q&A
        public static final String CAREER = "//p[contains(text(), 'Профессиональное развитие в')]"; //Сервис Карьера
        public static final String FREELANCE = "//p[contains(text(), 'Удаленная работа для IT-специалистов')]"; //Сервис Фриланс

        public static final String SEARCH = "//button[contains(@class, 'btn_navbar_search')]"; //Кнопка поиска
        public static final String INPUT_SEARCH = "//input[contains(@name, 'q')]"; //Поле ввода в строке поиска
        public static final String SEARCH_RESULT_TITLE = "//a[contains(@class, 'post__title_link')]"; //Заголовки статей на странице поиска
        public static final String LOGO = "//div[contains(@class, 'logo-wrapper')]"; //Логотип

        public static final String SWITCH_BUTTON = "//button[contains(@class, 'js-show_lang_settings')]"; //Кнопка переключения языка
        public static final String ENGLISH = "//label[contains(@for, 'hl_langs_en')]"; //Английский язык
        public static final String RUSSIAN = "//label[contains(@for, 'hl_langs_ru')]"; //Русский язык
        public static final String SUBMIT_SETTING = "//button[contains(@class, 'js-popup_save_btn')]"; //Кнопка "Сохранить настройки"

        public static final String TO_COME_IN = "//a[contains(@class, 'btn_navbar_login')]"; //Кнопка "Войти"
        public static final String REGISTRATION = "//a[contains(@class, 'btn_navbar_registration')]"; //Кнопка "Регистрация"

        public static final String ALL_STREAMS_EN = "//div[contains(@class, 'page-heade') and contains(text(), 'All streams')]"; //Заголовок "All streams"
        public static final String ALL_STREAMS_RU = "//div[contains(@class, 'page-heade') and contains(text(), 'Все потоки')]"; //Заголовок "Все потоки"

        public static final String HEADING_ENTRANCE = "//div[contains(@class, 'shadow-box__title') and contains(text(), 'Вход')]"; //Заголовок "Вход" на странице входа
        public static final String HEADING_REGISTRATION = "//div[contains(@class, 'shadow-box__title') and contains(text(), 'Регистрация')]"; //Заголовок "Регитсрация" на странице регитсрации

}
