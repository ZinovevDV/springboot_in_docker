package ru.mail.zinovev_dv;

import org.springframework.boot.SpringApplication;

//вместо спринг бут докера. можно использовать тестконтейнеры
//а здесь оставить это приложение (перед этим причесать конфиги)
// так как для примера они созданы 2мя способами
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.from(Application::main)
                .with(TestConfiguration2.class)
                .run(args);
    }
}
