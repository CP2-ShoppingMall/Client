package home.panel.body;

import home.MainFrame;
import home.library.RoundJTextField;
import home.library.RoundedButton;
import home.panel.head.HeadPanel;
import kimit.api.ClientException;
import kimit.api.ClientWrapper;
import kimit.server.Product;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO
//판매자 글 작성 페이지
public class WritePostPanel extends JPanel implements ActionListener
{
    private final MainFrame Frame;
    ImageIcon img_icon;
    Image img;
    JLabel img_label, title_label, price_label;
    RoundedButton complete_btn;
    JButton img_btn;
    JTextField title_txt, price_txt;

    public WritePostPanel(MainFrame frame)
    {
        Frame = frame;
        setLayout(null);
        setBackground(Color.white);

        //헤더
        HeadPanel head_panel = new HeadPanel(Frame);
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        //사진선택
        img_icon = new ImageIcon("src/home/image/icon/chooseimg.png");
        img = img_icon.getImage();
        img = img.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
        img_icon = new ImageIcon(img);
        img_btn = new JButton(img_icon);
        img_btn.setBounds(50, 170, 380, 380);
        img_btn.addActionListener(this);
        img_btn.setBackground(Color.white);
        img_btn.setBorder(BorderFactory.createLineBorder(Color.white));

        add(img_btn);

        //상품명 라벨
        title_label = new JLabel("상품명");
        title_label.setBounds(40,550,120,80);
        title_label.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        title_label.setForeground(new Color(33,39,37));
        add(title_label);
        //상품명
        title_txt = new RoundJTextField(30);
        title_txt.setBackground(new Color(157,184,177));
        title_txt.setBounds(160,565,270,50);
        title_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        title_txt.setText("");
        title_txt.setBorder(new LineBorder(new Color(157,184,177)));

        add(title_txt);

        //가격 라벨
        title_label = new JLabel("가격");
        title_label.setBounds(40,620,120,80);
        title_label.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        title_label.setForeground(new Color(33,39,37));
        add(title_label);
        //가격
        price_txt = new RoundJTextField(30);
        price_txt.setBackground(new Color(157,184,177));
        price_txt.setBounds(160,635,270,50);
        price_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        price_txt.setText("");
        price_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(price_txt);

        //작성 완료
        complete_btn = new RoundedButton("작성 완료");
        complete_btn.setBackground(new Color(33,39,37));
        complete_btn.setForeground(Color.white);
        complete_btn.setFont(new Font("맑은 고딕", Font.BOLD, 37));
        complete_btn.setBounds(16,730,450,90);
        complete_btn.addActionListener(this);

        add(complete_btn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source.equals(img_btn))
        {
            JFileChooser chooser = new JFileChooser();
            int r = chooser.showOpenDialog(this);
            if(r == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getAbsolutePath();
                //사진 재설정
                ImageIcon newImgIcon = new ImageIcon(name);
                Image newImg = newImgIcon.getImage();
                newImg = newImg.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
                newImgIcon = new ImageIcon(newImg);
                img_btn.setIcon(newImgIcon);
                img_btn.setBounds(50, 170, 380, 380);
            }
        }
        else if (source.equals(complete_btn))
        {
            ClientWrapper.get().getClient().post(new Product(title_txt.getText(), Integer.parseInt(price_txt.getText()), "", ((ImageIcon) img_btn.getIcon())));
            JOptionPane.showMessageDialog(this, "상품 등록이 완료되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
	        ((ListPanel) Frame.getPanel(BodyPanel.PRODUCT_LIST)).update(ClientWrapper.get().getClient().product());
	        Frame.setPanelVisible(BodyPanel.PRODUCT_LIST);
        }
    }
}