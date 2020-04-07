package elements;

public class LkPersonalElements {
    public static final String INPUT_FIRST_NAME = "//input[contains(@name, 'fname')]"; //Поля для ввода "Имя"
    public static final String INPUT_LAST_NAME = "//input[contains(@name, 'lname')]"; //Поля для ввода "Фамилия"
    public static final String INPUT_EU_FIRST_NAME = "//input[contains(@name, 'fname_latin')]"; //Поля для ввода "Имя" на латинице
    public static final String INPUT_EU_lAST_NAME = "//input[contains(@name, 'lname_latin')]"; //Поля для ввода "Фамилия" на латинице
    public static final String INPUT_BLOG_NAME = "//input[contains(@name, 'blog_name')]"; //Поля для ввода "Имя" в блоге
    public static final String INPUT_DATE_BIRTH = "//input[contains(@name, 'date_of_birth')]"; //Поля для ввода "Дата рождения"
    public static final String INPUT_EMAIL = "//input[contains(@name, 'email')]"; //Поля для ввода "Email"
    public static final String INPUT_PHONE = "//input[contains(@name, 'phone')]"; //Поля для ввода номера телефона
    public static final String COMMUNICATION_METHOD = "//div[contains(@class, 'lk-cv-block__input_md-4')]"; //Поля для выбора "Способ связи"
    public static final String ADD_COMMUNICATION_METHOD = "//button[contains(@class, 'js-formset-add js-lk-cv-custom-select-add')]"; //Кнопка "Добавить" контакт
    public static final String NEW_INPUT_COMMUNICATION_CONTACT = "//input[contains(@id, 'id_contact-0-value')]"; //Новое поле для ввода контакта
    public static final String SUBMIT_PERSONAL_FORM = "//button[contains(@title, 'Сохранить и продолжить')]"; //Кнопка "Сохранить и продолжить"

}
