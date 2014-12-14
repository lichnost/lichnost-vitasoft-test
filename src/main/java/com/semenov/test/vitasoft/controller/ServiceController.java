package com.semenov.test.vitasoft.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.semenov.test.vitasoft.model.Driver;
import com.semenov.test.vitasoft.model.DriverClass;
import com.semenov.test.vitasoft.model.Gender;
import com.semenov.test.vitasoft.model.Query;

@RestController
public class ServiceController {

	private static List<DriverClass> driverClasses = new ArrayList<DriverClass>();
	private static NavigableMap<Integer, Driver> drivers = new TreeMap<Integer, Driver>();

	static {
		DriverClass firstClass = new DriverClass("1");
		DriverClass secondClass = new DriverClass("2");
		DriverClass thirdClass = new DriverClass("3");

		driverClasses.add(firstClass);
		driverClasses.add(secondClass);
		driverClasses.add(thirdClass);

		drivers.put(0, new Driver(0, "Панфилов", "Лаврентий", "Акинфович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(1, new Driver(1, "Зуев", "Акакий", "Устинович", new Date(
				84, 1, 1), Gender.MALE, firstClass));
		drivers.put(2, new Driver(2, "Князев", "Федос", "Ермолаевич", new Date(
				84, 1, 1), Gender.MALE, firstClass));
		drivers.put(3, new Driver(3, "Шестаков", "Фока", "Гурьянович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(4, new Driver(4, "Харитонов", "Митрофан", "Федосович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(5, new Driver(5, "Гущин", "Панфил", "Аверкиевич", new Date(
				84, 1, 1), Gender.MALE, firstClass));
		drivers.put(6, new Driver(6, "Тимофеев", "Ипат", "Созонтович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(7, new Driver(7, "Артемьев", "Ардальон", "Ларионович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(8, new Driver(8, "Веселов", "Александр", "Макарович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(9, new Driver(9, "Потапов", "Мирослав", "Лукьянович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(10, new Driver(10, "Алексеев", "Нифонт", "Самойлович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(11, new Driver(11, "Шарапов", "Евтихий", "Никанорович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(12, new Driver(12, "Зиновьев", "Ермолай", "Арефьевич",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(13, new Driver(13, "Белоусов", "Харлам", "Варламович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(14, new Driver(14, "Крылов", "Федул", "Парфёнович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(15, new Driver(15, "Давыдов", "Юрий", "Елисеевич",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(16, new Driver(16, "Максимов", "Епифанович", "Свирид",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(17, new Driver(17, "Ермаков", "Кузьма", "Сидорович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(18, new Driver(18, "Фомичёв", "Мокей", "Абрамович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(19, new Driver(19, "Самсонов", "Пантелеймон",
				"Фектистович", new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(20, new Driver(20, "Большаков", "Прокоп", "Семёнович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(21, new Driver(21, "Шашков", "Фофан", "Степанович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(22, new Driver(22, "Анисимов", "Свирид", "Елизарович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(23, new Driver(23, "Захаров", "Елисей", "Никонович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(24, new Driver(24, "Мясников", "Гурьян", "Свиридович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(25, new Driver(25, "Анисимов", "Павел", "Ермолаевич",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(26, new Driver(26, "Наумов", "Кирило", "Пантелеимонович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(27, new Driver(27, "Морозов", "Панфил", "Гаврилович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(28, new Driver(28, "Соболев", "Феоктист", "Сидорович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
		drivers.put(29, new Driver(29, "Сазонов", "Пров", "Спиридонович",
				new Date(84, 1, 1), Gender.MALE, firstClass));
	}

	@RequestMapping(value = "/searchdriver", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody Collection<Driver> searchDriver(
			@RequestBody Query queryParam) {
		String query = queryParam.getQuery();
		List<Driver> result = new ArrayList<Driver>();
		if (StringUtils.isEmpty(query)) {
			result.addAll(drivers.values());
		} else {
			String upperQuery = query.toUpperCase();
			for (Entry<Integer, Driver> e : drivers.entrySet()) {
				Driver d = e.getValue();
				if ((!StringUtils.isEmpty(d.getFirstName()) && d.getFirstName()
						.toUpperCase().contains(upperQuery))
						|| (!StringUtils.isEmpty(d.getSecondName()) && d
								.getSecondName().toUpperCase()
								.contains(upperQuery))
						|| (!StringUtils.isEmpty(d.getMiddleName()) && d
								.getMiddleName().toUpperCase()
								.contains(upperQuery))) {
					result.add(d);
				}
			}
		}
		return result;
	}

	@RequestMapping(value = "/driver", method = RequestMethod.PUT, consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody boolean updateDriver(@RequestBody Driver driver) {
		if (driver.getId() == -1) {
			driver.setId(drivers.lastKey() + 1);
		}
		drivers.put(driver.getId(), driver);
		return true;
	}

	@RequestMapping(value = "/driver", method = RequestMethod.DELETE, consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody boolean deleteDriver(@RequestBody Driver driver) {
		drivers.remove(driver.getId());
		return true;
	}

	@RequestMapping(value = "/classes", method = RequestMethod.GET, consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody Collection<DriverClass> getDriverClasses() {
		return driverClasses;
	}

}
