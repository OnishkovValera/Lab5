package pack.Command;

import java.util.Scanner;

public class Help implements Command {

    @Override
    public void execute(String argument, Scanner scn) {
        System.out.println("""
                help : вывести справку по доступным командам\s
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                insert null {element} : добавить новый элемент с заданным ключом
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_key null : удалить элемент из коллекции по его ключу
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
                replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого
                remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный
                remove_all_by_capacity capacity : удалить из коллекции все элементы, значение поля capacity которого эквивалентно заданному
                average_of_engine_power : вывести среднее значение поля enginePower для всех элементов коллекции
                filter_less_than_engine_power enginePower : вывести элементы, значение поля enginePower которых меньше заданного
                """

        );
    }

}
