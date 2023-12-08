package home.panel.head;

import home.MainFrame;
import home.library.RoundJTextField;
import home.panel.body.BasketPanel;
import home.panel.body.BodyPanel;
import home.panel.body.ListPanel;
import home.panel.body.SearchListPanel;
import kimit.api.ClientWrapper;
import kimit.server.Product;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

//검색창
//TODO 서버구현
public class SearchPanel extends JPanel
{
    private final MainFrame Frame;
    public JButton  basket_button;
    public JButton search_button;
    public ImageIcon search_icon, basket_icon;

    Image search_img, basket_img;
    RoundJTextField search_txt;
    public SearchPanel(MainFrame frame)
    {
        Frame = frame;
        setBackground(Color.white);
        setSize(500,140);
        setLayout(null);
        //검색아이콘
        search_icon = new ImageIcon("src/home/image/icon/search.png");

        search_img = search_icon.getImage();
        search_img = search_img.getScaledInstance(45,50,Image.SCALE_SMOOTH);
        search_icon = new ImageIcon(search_img);
        search_button = new JButton(search_icon);
        search_button.setBounds(350,10, 45, 50);
        search_button.addActionListener(e ->
        {
            ArrayList<Product> products = new ArrayList<>(ClientWrapper.get().getClient().product().stream().filter(p -> p.getTitle().contains(search_txt.getText())).toList());
            ((ListPanel) Frame.getPanel(BodyPanel.PRODUCT_LIST)).update(products);
            Frame.setPanelVisible(BodyPanel.PRODUCT_LIST);
        });
        add(search_button);
        //장바구니아이콘
        basket_icon = new ImageIcon("src/home/image/icon/basket.png");
        basket_img = basket_icon.getImage();
        basket_img = basket_img.getScaledInstance(50, 55, Image.SCALE_SMOOTH);
        basket_icon = new ImageIcon(basket_img);
        basket_button = new JButton(basket_icon);
        basket_button.setBounds(407, 8, 55, 55);
        basket_button.addActionListener(e ->
        {
            ((BasketPanel) Frame.getPanel(BodyPanel.BASKET)).update(ClientWrapper.get().getClient().getMember().getBasket());
            Frame.setPanelVisible(BodyPanel.BASKET);
        });
        add(basket_button);
        //검색창
        search_txt = new RoundJTextField(30);
        search_txt.setBackground(new Color(157,184,177));
        search_txt.setBounds(15,10,317,50);
        search_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        search_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(search_txt);
        setVisible(true);
    }
}