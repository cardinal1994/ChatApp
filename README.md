Решил написать свой мини-месенджер, работает он следубщим образом:
1. На первом экране расположены 2 кнопки: Вход и Регистрация (переключение на соответствующий экран)
2. На экране регистрации Вы вводите никнейм, логин (в формате email) и пароль. В случае некорректного ввода появляется Toast.
3. На экране входа необходимо ввести ранее зарегистрированный логин и пароль. В случае некорректного ввода появляется Toast.
4. Четвертый экран состоит и двух частей: чаты и пользователи приложения. Пользователь выбирает собеседника и переходит на пятый экран. Если у человека есть с кем-то чат, то он сразу добавляется в список его чатов, он так же может перейти к диалогу по нажатию. Присутствует динамический поиск пользователей.
5. Экран чата. Если ваш собеседник прочитал отправленное вами сообщение, то вы это увидите.
6. Для выхода из аккаунта неоходимо перейти в Меню и нажать кнопку выхода.


Причины выбора технологий: Firebase, заменил BackEnd, DB и авторизацию. Остальное просто делал как знал (как учился по видео).
Впервые столкнулся с Authentication и Realtime Database. Очень крутая штука, раньше использовал только AdMob, день изучал материал, теперь буду использовать ее постоянно.
Сложности, с которыми довелось столкнуться: Пытался сделать PushNotifications, не вышло, но хочу их тоже добить, но пока в приоритете другие вещи.
С чем был знаком: СО всем, кроме Firebase
Что хотел бы изучить в ближайшее время: 1. Retrofit (понимаю принцип, практиковал мало)
					2. Multithreading (мне кажется, очень важно для приложений)
					3. RxJava
					4. Dagger 2 
					5. Подтянуть пробелы по UI и другое.

Описание как делал, писал по ходу:
1. Пдключаемся к Firebase
2. СОздаем новую базу данных в Firebase.
3. Изменяем цвета приложения (берем из библиотеки Material Design)
5. Создаем Register Activity
4. Добаляем Toolbar
5. Создаем элементы в activity_register.xml, затем инициализируем их в классе активности/
6. Заполняем RegisterActivity (создаем метод register, пишем его реализацию, добавляем слушателя на кнопку регистрации)
7. Создаем LoginActivity (добавялем Toolbar, инициализируем Views, на кнопку входа вешаем обработчик событий, который отвечает за авторизацию)
8. Создаем StartActivity (добавляем элементы в XML, инициализируем в StartActivity.class, по нажатию переходим на выбранную Activity)
9. Создаем MainActivity
	9.1. Заполняем XML.
	9.2. Инициализируем Views
	9.3. Создаем пакет Model, создаем POJO-класс User
	9.4. Создаем меню, переопределяем методы, пишем реализацию.
10. Создаем TabLayout и ViewPager с Fragments (создаем табы, фрагменты, пишем реализацию).
	10.1. Создаем внутренний класс ViewPagerAdapter
	10.2. Создаем вкладки и привязываем ViewPager
	10.3. Зполняем UsersFragment(XML, инициализация)
	10.4. Получаем Список пользователей из базы данных
11. Создаем MessagesACtivity (подключаем Toolbar, Firebase)
12. Настраиваем MessagesActivity, создаем чат
13. Добавляем поле для ввода, кнопку отправки сообщения, RecyclerView
14. В методе sendMessege пишем обработку сообщений(Добавление сообщения в бд)
15. Создаем макеты сообщений (мои и не мои / left and right)
16. Создаем POJO-класс Message
17. Создаем ChatAdapter для RecyclerView для сообщений. Устанавливаем его в список.
18. В классе MessagesAdapter создаем метод readMessages для получения списка сообщений
19. Заполняем ChatsFragment аналогично UsersFragment
20. Создаем динамический поиск (добавляем EditText с addTextChangedListener, добавляем еще одно поле в Users.class для поиска вне зависимости от регистра)
21. Создаем проверку просмотра сообщения (добавляем текстовое поле в XML, создаем метод seenMessage
22. Локализация
					




