package home.panel.body;

import home.MainFrame;
import home.panel.head.HeadPanel;
import kimit.api.ClientWrapper;
import kimit.server.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.IntStream;

//5. 장바구니 페이지
public class BasketPanel extends JPanel
{
    private final MainFrame Frame;
    ImageIcon product_icon;
    Image product_img;
    JLabel product_img_label, product_title_label, product_price_label, basket_label;
    public JButton buy_btn;
    JPanel buy_panel;
    JCheckBox buy_cb;
    private JPanel ListPanel;
    private ArrayList<Product> SelectedProducts;
    private ArrayList<ListComponent> Components;
    private static final Font FONT = new Font("맑은고딕", Font.BOLD, 24);
    private static final Color COLOR = new Color(72,84,81);
    public BasketPanel(MainFrame frame)
    {
        Frame = frame;
        setLayout(null);
        setSize(500,700);
        setBackground(Color.white);

        //헤더
        HeadPanel head_panel = new HeadPanel(Frame);
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        //장바구니 라벨
        basket_label = new JLabel("장바구니 목록");
        basket_label.setFont(new Font("맑은고딕", Font.BOLD, 18));
        basket_label.setForeground(new Color(153,153,153));
        basket_label.setBounds(15,175, 150,30);
        add(basket_label);

        //구매하기 버튼
        buy_btn = new JButton("구매하기");
        buy_btn.setBackground(new Color(33,39,37));
        buy_btn.setForeground(Color.black);
        buy_btn.setFont(new Font("맑은 고딕", Font.BOLD, 37));
        buy_btn.setBounds(16,730,450,90);
        buy_btn.addActionListener(e ->
        {
            ClientWrapper.get().getClient().purchaseInBasket(SelectedProducts);
            JOptionPane.showMessageDialog(this, new DecimalFormat("#,###").format(SelectedProducts.stream().mapToInt(Product::getPrice).sum()) + " 원 구매가 완료되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
            for (var loop : SelectedProducts)
            {
                for (var loop2 : Components)
                {
                    if (loop2.Product.getTitle().equals(loop.getTitle()) && loop2.Product.getPrice() == loop.getPrice())
                    {
                        Components.remove(loop2);
                        break;
                    }
                }
            }
	        ArrayList<Product> products = new ArrayList<>(Components.stream().map(f -> f.Product).toList());
            update(products);
            SelectedProducts.clear();
        });
        add(buy_btn);

        ListPanel = new JPanel();
        ListPanel.setLayout(null);
        ListPanel.setBounds(0, 210, 500, 500);
        add(ListPanel);

        SelectedProducts = new ArrayList<>();
        Components = new ArrayList<>();

        setVisible(true);
    }

    public void update(ArrayList<Product> products)
    {
        ListPanel.removeAll();
        ListPanel.repaint();
        Components.clear();
        int height = 0;
        for (var loop : products)
        {
            ListComponent component = new ListComponent(loop);
            component.setBounds(0, 200 * height, 500, 200);
            ListPanel.add(component);
            Components.add(component);
            height++;
        }
    }

    class ListComponent extends JPanel implements ItemListener
    {
        private final Product Product;

        public ListComponent(Product product)
        {
            Product = product;
            setLayout(null);
            setBackground(new Color(157,184,177));

            JLabel imageLabel = new JLabel(new ImageIcon(Product.getImage().getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            imageLabel.setBounds(40, 20, 150, 150);
            add(imageLabel);

            JCheckBox checkBox = new JCheckBox();
            checkBox.setBounds(5, 5, 20, 20);
            checkBox.setBackground(new Color(157,184,177));
            checkBox.addItemListener(this);
            add(checkBox);

            JLabel titleLabel = new JLabel(Product.getTitle());
            titleLabel.setFont(FONT);
            titleLabel.setForeground(COLOR);
            titleLabel.setBounds(210, 25, 250,30);
            add(titleLabel);

            JLabel priceLabel = new JLabel(Product.getPriceText());
            priceLabel.setFont(FONT);
            priceLabel.setForeground(COLOR);
            priceLabel.setBounds(210,50,250,60);
            add(priceLabel);
        }

        public kimit.server.Product getProduct()
        {
            return Product;
        }

        @Override
        public void itemStateChanged(ItemEvent e)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
                SelectedProducts.add(Product);
            else if (e.getStateChange() == ItemEvent.DESELECTED)
                SelectedProducts.remove(Product);
        }
    }
}

