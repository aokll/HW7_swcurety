package ru.gb.HW7_swcurety;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Базовое задание:
 *
 * Внимание ДЗ выполнять в версии SpringBoot:3.2.5(на основе example4_sem7)
 *
 * Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в
 * зависимости от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.
 *
 * Создайте ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN
 * Создайте ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от их роли
 * Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств Spring Security
 * Если неаутентифицированный пользователь пытается получить доступ к /private-data,
 * он должен быть перенаправлен на форму входа
 * Подсказка:
 *
 * Файл HTML:
 *
 * <!DOCTYPE html>
 * <html lang="en">
 * <head>
 * <meta charset="UTF-8">
 * <title>Login</title>
 * </head>
 * <body>
 * <h2>Login</h2>
 * <form action="/login" method="post">
 * <div>
 * <label for="username">Username:</label>
 * <input type="text" id="username" name="username"/>
 * </div>
 * <div>
 * <label for="password">Password:</label>
 * <input type="password" id="password" name="password"/>
 * </div>
 * <input type="submit" value="Login"/>
 * </form>
 * </body>
 * </html>
 */
@SpringBootApplication
public class Hw7SwcuretyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw7SwcuretyApplication.class, args);
	}

}
