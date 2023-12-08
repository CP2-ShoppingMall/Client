package home.panel.head;

import home.MainFrame;
import home.library.RoundJTextField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

//Body
//홈 화면
public class HeadPanel extends JPanel
{
    private final MainFrame Frame;
    public SearchPanel search_panel;
    public HeadPanel(MainFrame frame)
    {
        Frame = frame;
        setSize(500, 200);
        setBackground(Color.white);
        setLayout(null);
        //로고 패널
        LogoPanel logo_panel = new LogoPanel();
        logo_panel.setBounds(0,0,500,90);
        add(logo_panel);
        //검색 패널
        search_panel = new SearchPanel(Frame);
        search_panel.setBounds(0,90,500,70);
        add(search_panel);
    }
}

//쇼핑몰 로고
class LogoPanel extends JPanel {
    JLabel logo_label;
    ImageIcon logo_icon;
    Image logo_img;
    public LogoPanel(){
        setLayout(null);
        setBackground(Color.white);
        setSize(500,90);
        //로고
        logo_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/home/image/icon/logo.png")));
        logo_img = logo_icon.getImage();
        logo_img = logo_img.getScaledInstance(230,60,Image.SCALE_SMOOTH);
        logo_icon = new ImageIcon(logo_img);
        logo_label = new JLabel(logo_icon);
        logo_label.setBounds(120,20, 230, 60);
        add(logo_label);
    }
}