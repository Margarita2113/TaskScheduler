package org.example.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskFounded() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskNoFounded() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicFounded() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNoFounded() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Тест");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingFoundedInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("версии");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNoFoundedInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("тест");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingFoundedInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNoFoundedInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("тест");

        Assertions.assertFalse(actual);
    }
}