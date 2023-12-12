package home.panel.body;

import home.MainFrame;
import home.panel.head.HeadPanel;
import kimit.api.ClientWrapper;

import javax.swing.*;
import java.awt.*;

//마이 페이지 (구매목록)
public class MypagePanel extends JPanel
{
    private final MainFrame Frame;
    JLabel product_img_label, product_title_label, product_price_label, product_label;

    JPanel buy_panel;
    private JScrollPane Scroll;
    private final Font FONT = new Font("맑은고딕", Font.BOLD, 24);
    private final Color COLOR = new Color(72,84,81);

    public MypagePanel(MainFrame frame)
    {
        Frame = frame;
        setLayout(null);
        setSize(500,700);
        setBackground(Color.white);
        //헤더
        HeadPanel head_panel = new HeadPanel(Frame);
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        //구매목록 라벨
        product_label = new JLabel("구매 목록");
        product_label.setFont(new Font("맑은고딕", Font.BOLD, 18));
        product_label.setForeground(new Color(153,153,153));
        product_label.setBounds(15,185, 150,30);
        add(product_label);

        //While, For문을 사용해서 밑에 상품들을 출력해내야 할 것 같습니다~!
        //구매 패널
        buy_panel = new JPanel();
        buy_panel.setLayout(null);
        buy_panel.setBackground(new Color(157,184,177));
        buy_panel.setBounds(0,220,500,200);
        Scroll = new JScrollPane();
        Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Scroll.setBounds(0, 220, 500, 600);

        //add(Scroll);
        add(buy_panel);

        setVisible(true);
    }

    public void update()
    {
        int height = 0;
        for (var loop : ClientWrapper.get().getClient().getMember().getPurchase())
        {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(null);
            productPanel.setBackground(new Color(157, 184, 177));
            productPanel.setBounds(0, height, 500, 200);
            height += 200;
            product_img_label = new JLabel(new ImageIcon(loop.getImage().getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            product_img_label.setBounds(40, 20, 150, 150);
            productPanel.add(product_img_label);
            product_title_label = new JLabel(loop.getTitle());
            product_title_label.setFont(FONT);
            product_title_label.setForeground(COLOR);
            product_title_label.setBounds(210, 25, 250, 30);
            productPanel.add(product_title_label);
            product_price_label = new JLabel(loop.getPriceText());
            product_price_label.setFont(FONT);
            product_price_label.setForeground(COLOR);
            product_price_label.setBounds(210, 50, 250, 60);
            productPanel.add(product_price_label);
            buy_panel.add(productPanel);
        }
        buy_panel.setBounds(0, 220, 500, height);
    }
}