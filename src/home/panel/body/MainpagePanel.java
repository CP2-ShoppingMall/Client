package home.panel.body;

import home.MainFrame;
import home.library.RoundJPassWordField;
import home.library.RoundJTextField;
import home.library.RoundedButton;
import home.panel.head.TopBarPanel;
import kimit.api.ClientException;
import kimit.api.ClientWrapper;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainpagePanel extends JPanel implements ActionListener
{
    private final MainFrame Frame;
    ImageIcon logo_icon;
    Image logo_img;
    JLabel logo, id, pwd;
    public RoundJTextField id_txt;
    public RoundJPassWordField pwd_txt;
    public RoundedButton login_btn,sign_btn;


    public MainpagePanel(MainFrame frame)
    {
        Frame = frame;
        setLayout(null);
        setBackground(Color.white);

        //상단 바
        TopBarPanel topbar_panel = new TopBarPanel();
        topbar_panel.setBounds(0,0,500, 45);
        add(topbar_panel);

        //로고
        logo_icon = new ImageIcon("src/home/image/icon/mainlogo.png");
        logo_img = logo_icon.getImage();
        logo_img = logo_img.getScaledInstance(410,160,Image.SCALE_SMOOTH);
        logo_icon = new ImageIcon(logo_img);
        logo = new JLabel(logo_icon);
        logo.setBounds(40,250, 410, 160);
        add(logo);


        //아이디 라벨
        id = new JLabel("아이디");
        id.setBounds(80,410,80,80);
        id.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        id.setForeground(new Color(33,39,37));
        add(id);

        //아이디
        id_txt = new RoundJTextField(30);
        id_txt.setBackground(new Color(157,184,177));
        id_txt.setBounds(180,425,230,50);
        id_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        id_txt.setText("");
        id_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(id_txt);

        //비밀번호 라벨
        pwd = new JLabel("비밀번호");
        pwd.setBounds(60,490,120,80);
        pwd.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        pwd.setForeground(new Color(33,39,37));
        add(pwd);

        //비밀번호
        pwd_txt = new RoundJPassWordField(30);
        pwd_txt.setBackground(new Color(157,184,177));
        pwd_txt.setBounds(180,505,230,50);
        pwd_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        pwd_txt.setText("");
        pwd_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(pwd_txt);

        //로그인
        login_btn = new RoundedButton("로그인");
        login_btn.setBackground(new Color(33,39,37));
        login_btn.setForeground(Color.white);
        login_btn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        login_btn.setBounds(90,605,135,55);
        login_btn.addActionListener(this);
        add(login_btn);

        //회원가입
        sign_btn = new RoundedButton("회원가입");
        sign_btn.setBackground(new Color(33,39,37));
        sign_btn.setForeground(Color.white);
        sign_btn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        sign_btn.setBounds(260,605,135,55);
        sign_btn.addActionListener(this);
        add(sign_btn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        RoundedButton source = (RoundedButton) e.getSource();
        if (source.equals(login_btn))
        {
            try
            {
                ClientWrapper.get().getClient().login(id_txt.getText(), Arrays.toString(pwd_txt.getPassword()));
                ((ListPanel) Frame.getPanel(BodyPanel.PRODUCT_LIST)).update(ClientWrapper.get().getClient().product());
                Frame.setPanelVisible(BodyPanel.PRODUCT_LIST);
            }
            catch (ClientException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (source.equals(sign_btn))
        {
            Frame.setPanelVisible(BodyPanel.REGISTER);
        }
    }
}
