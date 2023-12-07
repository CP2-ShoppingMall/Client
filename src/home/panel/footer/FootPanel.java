package home.panel.footer;
import home.MainFrame;
import home.panel.body.BodyPanel;
import home.panel.body.MypagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FootPanel extends JPanel
{
    private MainFrame Frame;
    JLabel home_label, mypage_label, setting_label;
    ImageIcon home_icon, mypage_icon, setting_icon;
    Image home_img, mypage_img, setting_img;
    public FootPanel(MainFrame frame)
    {
        Frame = frame;
        setSize(500, 120);
        setLayout(null);
        setBackground(Color.white);
        //홈아이콘
        home_icon = new ImageIcon("src/home/image/icon/home.png");
        home_img = home_icon.getImage();
        home_img = home_img.getScaledInstance(60 ,60,Image.SCALE_SMOOTH);
        home_icon = new ImageIcon(home_img);
        home_label = new JLabel(home_icon);
        home_label.setBounds(20,15, 70, 70);
        home_label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Frame.setPanelVisible(BodyPanel.PRODUCT_LIST);
            }
        });
        add(home_label);

        //마이페이지아이콘
        mypage_icon = new ImageIcon("src/home/image/icon/user.png");
        mypage_img = mypage_icon.getImage();
        mypage_img = mypage_img.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        mypage_icon = new ImageIcon(mypage_img);
        mypage_label = new JLabel(mypage_icon);
        mypage_label.setBounds(215,15, 70, 70);
        mypage_label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                ((MypagePanel) Frame.getPanel(BodyPanel.MYPAGE)).update();
                Frame.setPanelVisible(BodyPanel.MYPAGE);
            }
        });
        add(mypage_label);

        //셋팅아이콘
        setting_icon = new ImageIcon("src/home/image/icon/setting.png");
        setting_img = setting_icon.getImage();
        setting_img = setting_img.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        setting_icon = new ImageIcon(setting_img);
        setting_label = new JLabel(setting_icon);
        setting_label.setBounds(395,15, 70, 70);
        setting_label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Frame.setPanelVisible(BodyPanel.WRITE_POST);
            }
        });
        add(setting_label);
        setVisible(true);
    }

}