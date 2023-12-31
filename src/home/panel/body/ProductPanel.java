package home.panel.body;

import home.MainFrame;
import home.panel.head.HeadPanel;
import kimit.api.ClientWrapper;
import kimit.server.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//상품 상세 페이지
public class ProductPanel extends JPanel implements ActionListener
{
    private final MainFrame Frame;
    private Product Product;
    ImageIcon product_icon;
    Image product_img;
    JLabel product_img_label, product_title_label, product_price_label;
    JButton basket_btn, buy_btn;
    JPanel buy_panel;
    public ProductPanel(MainFrame frame)
    {
        Frame = frame;
        setLayout(null);
        setSize(500,700);
        setBackground(Color.white);

        //헤더
        HeadPanel head_panel = new HeadPanel(Frame);
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        //상품 사진
        product_icon = new ImageIcon("src/home/image/product/3.png");
        product_img = product_icon.getImage();
        product_img = product_img.getScaledInstance(370,370, Image.SCALE_SMOOTH);
        product_icon = new ImageIcon(product_img);
        product_img_label = new JLabel(product_icon);
        product_img_label.setBounds(40,180,370,370);
        add(product_img_label);

        //구매 패널
        buy_panel = new JPanel();
        buy_panel.setLayout(null);
        buy_panel.setBackground(new Color(157,184,177));
        buy_panel.setBounds(0,590,500,255);

        product_title_label = new JLabel("갤럭시탭S9 플러스");
        product_title_label.setFont(new Font("맑은고딕", Font.BOLD, 24));
        product_title_label.setForeground(new Color(72,84,81));
        product_title_label.setBounds(20, 40, 250,30);
        buy_panel.add(product_title_label);

        product_price_label = new JLabel("950,000");
        product_price_label.setFont(new Font("맑은고딕", Font.BOLD, 34));
        product_price_label.setForeground(new Color(72,84,81));
        product_price_label.setBounds(20,65,250,60);
        buy_panel.add(product_price_label);

        basket_btn = new JButton("장바구니 담기");
        basket_btn.setBackground(new Color(72,84,81));
        basket_btn.setForeground(Color.black);
        basket_btn.setBounds(270,45,190,60);
        basket_btn.setFont(new Font("맑은 고딕",Font.BOLD,24));
        basket_btn.addActionListener(this);
        buy_panel.add(basket_btn);

        buy_btn = new JButton("구매하기");
        buy_btn.setBackground(new Color(33,39,37));
        buy_btn.setForeground(Color.black);
        buy_btn.setFont(new Font("맑은 고딕", Font.BOLD, 37));
        buy_btn.setBounds(20,135,450,90);
        buy_btn.addActionListener(this);
        buy_panel.add(buy_btn);
        add(buy_panel);
    }

    public void load(Product product)
    {
        Product = product;
        product_img_label.setIcon(new ImageIcon(product.getImage().getImage().getScaledInstance(370, 370, Image.SCALE_SMOOTH)));
        product_title_label.setText(product.getTitle());
        product_price_label.setText(product.getPriceText());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton source = ((JButton) e.getSource());
        if (source.equals(basket_btn))
        {
            ClientWrapper.get().getClient().basket(Product);
            JOptionPane.showMessageDialog(this, "장바구니에 등록되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (source.equals(buy_btn))
        {
            ArrayList<Product> products = new ArrayList<>();
            products.add(Product);
            ClientWrapper.get().getClient().purchase(products);
            JOptionPane.showMessageDialog(this, Product.getPriceText() + " 원 구매가 완료되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
