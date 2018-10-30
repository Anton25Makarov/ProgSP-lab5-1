import java.awt.*;
import java.applet.*;

//создать класс апплета, который реализует интерфейс Runnable
public class AppletThreadSample extends Applet implements Runnable {
    private Thread T; //создать объект потока
    //объявление переменных
    private ShapeString m_ShapeString = null;  //для строки
    private ShapeOval m_ShapeOval = null; //для овала
    private ShapeRect m_ShapeRect = null; //для квадрата

    public void run() { //реализация метода run, точка входа в поток
        setBackground(Color.yellow); //фон апплета зарисовывается желтым
        while (true) { //бесконечный цикл
            repaint(); //перерисовка апплета или вызов метода paint
            try {
                T.sleep(10); //приостановка апплета на 10 миллисекунл
            } catch (InterruptedException e) {
            }
        }
    }

    public void init() { //метод инициализации апплета
        T = new Thread(this); //создание потока и привязка его к текущему классу
        T.start(); //запуск потока (вызывается run)
//создание объектов
        m_ShapeString = new ShapeString();
        m_ShapeOval = new ShapeOval();
        m_ShapeRect = new ShapeRect();
    }

    public void paint(Graphics g) {
        //метод прорисовки апплета
//прорисовка строки
        g.drawString("This is ShapeString",
                m_ShapeString.x_String, m_ShapeString.y_String);
//прорисовка квадрата
        g.setColor(Color.red);
        g.drawRect(m_ShapeRect.x_Rect, m_ShapeRect.y_Rect,
                m_ShapeRect.w_Rect, m_ShapeRect.h_Rect);
//прорисовка овала
        g.setColor(Color.CYAN);
        g.fillOval(m_ShapeOval.x_Oval, m_ShapeOval.y_Oval,
                m_ShapeOval.w_Oval, m_ShapeOval.h_Oval);
    }

    //класс ShapeString реализующий интерфейс Runnable
    class ShapeString implements Runnable {
        Thread T;
        int x_String, y_String; //координаты строки

        public ShapeString() { //конструктор
            T = new Thread(this); //создание объекта Thread
//установление начальных координат строки
            x_String = 100;
            y_String = 100;
            T.start(); //запуск потока (вызов метода run)
        }

        public void run() { //метод run
            for (; ; ) {
                x_String += 15; //изменение координаты строки
                try {
                    T.sleep(1000); //приостановка работы потока на 1000 миллисекунд
                } catch (InterruptedException e) {
                }
            }
        }
    }

    //класс ShapeRect реализующий интерфейс Runnable
    class ShapeRect implements Runnable {
        Thread T;
        int x_Rect, y_Rect, w_Rect, h_Rect; //координаты и размеры квадрата

        public ShapeRect() { //конструктор
            T = new Thread(this); //создание объекта Thread
//установление начальных координат квадрата
            x_Rect = 350;
            y_Rect = 50;
            w_Rect = 100;
            h_Rect = 100;
            T.start();//запуск потока (вызов метода run)
        }

        public void run() { //метод run
            for (; ; ) {
                x_Rect -= 15;  //изменение координаты квадрата
                try {
                    T.sleep(500);  //приостановка работы потока на 1000 миллисекунд
                } catch (InterruptedException e) {
                }
            }
        }
    }

    //класс ShapeOval реализующий интерфейс Runnable
    class ShapeOval implements Runnable {
        Thread T;
        int x_Oval, y_Oval, w_Oval, h_Oval; //координаты и размеры овала

        public ShapeOval() { //конструктор
            T = new Thread(this); //создание объекта Thread
//установление начальных координат овала
            x_Oval = 30;
            y_Oval = 30;
            w_Oval = 100;
            h_Oval = 90;
            T.start(); //запуск потока (вызов метода run)
        }

        public void run() {//метод run
            for (; ; ) {//изменение координат овала
                x_Oval += 8;
                y_Oval += 7;
                try {
                    T.sleep(100); //приостановка работы потока на 100 миллисекунд
                } catch (InterruptedException e) {
                }
            }
        }
    }
}