package elements;

public class QAndAElements {
    public static final String TO_LEARN_MORE = "//a[contains(@class, 'btn_green') and contains(text(), 'Узнать больше')]"; //Ссылка "Узнать больше"
    public static final String ABOUT_SERVICE = "//h2[contains(@class, 'page__header-title') and contains(text(), 'О сервисе')]"; //Заголовок на странице

    public static final String SEARCH_RESULT_QUESTION = "//a[contains(@class, 'question__title-link')]"; //Заголовки вопросов на странице поиска
    public static final String FILTER_NEW_QUESTION = "//div[contains(@class, 'page__filters')]//a[contains(text(), 'Новые вопросы')]";
    public static final String FILTER_INTERESTING_QUESTION = "//div[contains(@class, 'page__filters')]//a[contains(text(), 'Интересные')]";
    public static final String FILTER_WITHOUT_ANSWER_QUESTION = "//div[contains(@class, 'page__filters')]//a[contains(text(), 'Без ответа')]";

}
