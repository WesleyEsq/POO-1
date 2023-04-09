package Vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import modelo.Asiento;

/**
 *
 * @author Wess
 */
public class PanelAsientos extends javax.swing.JPanel {

    /**
     * Creates new form Seleccionador
     */
    private Asiento seatStatus [][];
    
    public Asiento[][] getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Asiento [][] seatStatus) {
        this.seatStatus = seatStatus;
    }
    
    public PanelAsientos() {
        String string = ""; char ch = 'a';
        Asiento grid [][] = new Asiento[5][5];     
        for (int row=0; row < grid.length; row++){  
            for (int col=0; col < grid[row].length; col++){
                string = ch + string;
                string += Integer.toString(col + 1);
                grid [row][col] = new Asiento(string);
                (grid[row][col]).setIsActive(true);
                string = "";
            }
            ch ++;
        }
        this.seatStatus = grid;
        initComponents();
        initialize(grid);
    }
    
    private void initialize(Asiento [][]matrix){
        String string = "";
        int x = 1; int y = 1;
        for (int row=0; row < matrix.length; row++){
            for (int col=0; col < matrix[row].length; col++){
                x = col;
            }
            y = row;
        }
        setLayout(new GridLayout(5,5, 4, 4));
        for (int row=0; row < matrix.length; row++){
            for (int col=0; col < matrix[row].length; col++){
                boolean value = (matrix[row][col]).isActive();
                string = (matrix[row][col]).getID();
                JButton btn = new JButton(string);
                btn.setText(string);
                string = "";
                
                btn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String string = btn.getText();
                        char line = string.charAt(0);
                        int col = line - 'a';
                        int row = parseInt(string.substring(1));
                        row --;
                        
                        boolean value = (seatStatus[col][row]).isActive();
                        if (value){
                            btn.setBackground(Color.ORANGE);
                            (seatStatus[col][row]).setIsActive(false);
                        }
                        else{
                            btn.setBackground(Color.GREEN);
                            (seatStatus[col][row]).setIsActive(true);
                        }
                    }
                });
                
                if (value){
                    btn.setBackground(Color.GREEN);
                }
                else{
                    btn.setBackground(Color.RED);
                    btn.setEnabled(false);
                }
                this.add(btn);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

