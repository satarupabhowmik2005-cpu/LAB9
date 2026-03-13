import java.awt.*;
import java.awt.event.*;

class StopWatch extends Frame implements ActionListener, Runnable {

    Button start, stop;
    Label timeLabel;
    Thread t;
    int sec = 0;
    boolean running = false;

    StopWatch() {

        setLayout(new FlowLayout());

        start = new Button("Start");
        stop = new Button("Stop");
        timeLabel = new Label("Time: 0");

        add(start);
        add(stop);
        add(timeLabel);

        start.addActionListener(this);
        stop.addActionListener(this);

        setSize(200,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == start){
            running = true;
            t = new Thread(this);
            t.start();
        }

        if(e.getSource() == stop){
            running = false;
        }
    }

    public void run() {
        try{
            while(running){
                sec++;
                timeLabel.setText("Time: " + sec);
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new StopWatch();
    }
}
