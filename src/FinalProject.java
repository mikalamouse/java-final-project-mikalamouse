import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionListener;

public class FinalProject implements ActionListener {
    int shotsLeftCount = 40;
    int winCount = 14;
    JFrame frame = new JFrame("Battleship");
    JButton button[][] = new JButton [10][10];
    JLabel shotsLeft = new JLabel("Number of shots left:" + shotsLeftCount);

    int[][] hiddenBoard = new int[10][10];

    Container North = new Container();
    Container Center = new Container();

    public static void main(String[] args) {
        new FinalProject();

    }

    public FinalProject(){
        frame.setSize(1000,1000);
        frame.setLayout(new BorderLayout());

        Center.setLayout(new GridLayout(10, 10));
        for (int row = 0; row < button.length; row++) {
            for (int column = 0; column < button[0].length; column++) {
                button[column][row] = new JButton();
                Center.add(button[column][row]);
                button[column][row].addActionListener(this);
            }
        }
        frame.add(Center, BorderLayout.CENTER);

        North.setLayout(new GridLayout(1,1));
        North.add(shotsLeft);
        frame.add(North, BorderLayout.NORTH);



        frame.setVisible(true);
        setHiddenBoard();
    }

    public void setHiddenBoard(){
        int chooseNumber = (int )(Math.random() * 4 + 1);
        if(chooseNumber == 1){
            //System.out.println(chooseNumber);
           // System.out.println(1);
            //5 piece
            hiddenBoard[4][1] = 1;
            hiddenBoard[5][1] = 1;
            hiddenBoard[6][1] = 1;
            hiddenBoard[7][1] = 1;
            hiddenBoard[8][1] = 1;
            //4 piece
            hiddenBoard[4][3] = 1;
            hiddenBoard[4][4] = 1;
            hiddenBoard[4][5] = 1;
            hiddenBoard[4][6] = 1;
            //2 piece
            hiddenBoard[8][6] = 1;
            hiddenBoard[8][7] = 1;
            //3 piece
            hiddenBoard[1][7] = 1;
            hiddenBoard[1][8] = 1;
            hiddenBoard[1][9] = 1;
        }
        else if  (chooseNumber == 2){
           // System.out.println(chooseNumber);
           // System.out.println(2);
            //2 piece
            hiddenBoard[9][0] = 1;
            hiddenBoard[9][1] = 1;
            //3 piece
            hiddenBoard[4][3] = 1;
            hiddenBoard[5][3] = 1;
            hiddenBoard[6][3] = 1;
            //4 piece
            hiddenBoard[6][8] = 10;
            hiddenBoard[7][8] = 1;
            hiddenBoard[8][8] = 1;
            hiddenBoard[9][8] = 1;
            //5 piece
            hiddenBoard[0][3] = 1;
            hiddenBoard[0][4] = 1;
            hiddenBoard[0][5] = 1;
            hiddenBoard[0][6] = 1;
            hiddenBoard[0][7] = 1;

        }
        else if (chooseNumber == 3){
           // System.out.println(chooseNumber);
           // System.out.println(3);
            // 2 piece
            hiddenBoard[5][2] = 1;
            hiddenBoard[5][3] = 1;
            //3 piece
            hiddenBoard[0][5] = 1;
            hiddenBoard[1][5] = 1;
            hiddenBoard[2][5] = 1;
            //4 piece
            hiddenBoard[6][5] = 1;
            hiddenBoard[7][5] = 1;
            hiddenBoard[8][5] = 1;
            hiddenBoard[9][5] = 1;
            //5 piece
            hiddenBoard[4][5] = 1;
            hiddenBoard[4][6] = 1;
            hiddenBoard[4][7] = 1;
            hiddenBoard[4][8] = 1;
            hiddenBoard[4][9] = 1;

        }
        else{
            //System.out.println(chooseNumber);
            //System.out.println(4);
            //2 piece
            hiddenBoard[3][0] = 1;
            hiddenBoard[4][0] = 1;
            //3 piece
            hiddenBoard[6][2] = 1;
            hiddenBoard[6][3] = 1;
            hiddenBoard[6][4] = 1;
            //4 piece
            hiddenBoard[1][4] = 1;
            hiddenBoard[1][5] = 1;
            hiddenBoard[1][6] = 1;
            hiddenBoard[1][7] = 1;
            //5 piece
            hiddenBoard[5][7] = 1;
            hiddenBoard[6][7] = 1;
            hiddenBoard[7][7] = 1;
            hiddenBoard[8][7] = 1;
            hiddenBoard[9][7] = 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //setHiddenBoard();
        for (int row = 0; row < button.length ; row++) {
            for (int column = 0; column < button[0].length; column++) {
                if(e.getSource().equals(button[column][row])){
                    if(hiddenBoard[column][row] == 0){
                        shotsLeftCount = shotsLeftCount -1;
                        shotsLeft.setText(("Shots Left : " + shotsLeftCount)+"");
                        //System.out.println(button[column][row]);
                    button[column][row].setText("X");
                    didTheyWin();
                }
                else{
                        shotsLeftCount = shotsLeftCount -1;
                        shotsLeft.setText(("Shots Left : " + shotsLeftCount)+"");
                        button[column][row].setText("Gotcha");
                        winCount = winCount - 1;
                        didTheyWin();
                    }
                }
            }

        }
    }

    public void didTheyWin(){
        if (winCount == 0){
            System.out.println("you won");
        }
        else {
            if (shotsLeftCount == 0){
                 System.out.println("you lost");


            }
        }
    }
}

