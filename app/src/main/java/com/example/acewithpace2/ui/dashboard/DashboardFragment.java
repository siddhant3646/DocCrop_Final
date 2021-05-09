package com.example.acewithpace2.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acewithpace2.RecyclerViewOnclickInterface;
import com.example.acewithpace2.shoppingcart.CartFragment;
import com.example.acewithpace2.R;
import com.example.acewithpace2.shoppingcart.FertilizerDetails;
import com.example.acewithpace2.shoppingcart.adapter.CategoryAdapter;
import com.example.acewithpace2.shoppingcart.adapter.MostPopularAdapter;
import com.example.acewithpace2.shoppingcart.model.Category;
import com.example.acewithpace2.shoppingcart.model.MostPopular;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements RecyclerViewOnclickInterface {

    private DashboardViewModel dashboardViewModel;
    RecyclerView mostPopularView,categoryRecyclerView;
    MostPopularAdapter mostPopularAdapter;
    List<MostPopular> mostPopularList;
    Context context;

    ImageView cart;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dashboard,container,false);


            mostPopularView = v.findViewById (R.id.most_popular_recyclerView);
            categoryRecyclerView = v.findViewById(R.id.categoryRecycler);
            int card4 = FertilizerDetails.chlorpyriphos_hispa2_image;
            int card3 = FertilizerDetails.phorate_stemb2_image;
            int card2 = FertilizerDetails.cartap_stemb1_image;
            int card1 = FertilizerDetails.triazophos_hispa1_image;
            int card5 = FertilizerDetails.malathion_gb2_gif_image;
            int card6 = FertilizerDetails.carbaryl_50_gb1_image;
            int b4 = R.drawable.b4;
            int b3 = R.drawable.b3;
            int b2 = R.drawable.b2;
            int b1 = R.drawable.b1;


            cart = v.findViewById(R.id.addToCart2);
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CartFragment cartF = new CartFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment,cartF).commit();

                }
            });

            int fertilizer = R.drawable.fertilizer;


            // adding data to model
            categoryList = new ArrayList<>();
            categoryList.add(new Category(1, card1));
            categoryList.add(new Category(2, card2));
            categoryList.add(new Category(3, card3));
            categoryList.add(new Category(4, card4));
            categoryList.add(new Category(5, card5));
            categoryList.add(new Category(6, card6));
            categoryList.add(new Category(7, card2));
            categoryList.add(new Category(8, card3));
            categoryList.add(new Category(4, card4));
            categoryList.add(new Category(5, card5));
            categoryList.add(new Category(6, card6));
            categoryList.add(new Category(7, card2));
            categoryList.add(new Category(8, card3));


            // adding data to model
            mostPopularList = new ArrayList<>();


            mostPopularList.add(new MostPopular("Watermelon", "Watermelon has high water content and also provides some fiber.", "₹ 80", "1", "KG", card4 , b4));
            mostPopularList.add(new MostPopular("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₹ 85", "1", "KG", card3, b3));
            mostPopularList.add(new MostPopular("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "₹ 30", "1", "KG", card2, b1));
            mostPopularList.add(new MostPopular("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₹ 30", "1", "PC", card1, b2));
            mostPopularList.add(new MostPopular("Watermelon", "Watermelon has high water content and also provides some fiber.", "₹ 45", "2", "KG", card4 , b4));
            mostPopularList.add(new MostPopular("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₹ 15", "0.5", "KG", card3, b3));


            setMostPopularRecycler(mostPopularList);
            setCategoryRecycler(categoryList);
            openCart();

        return v;

        }



        private void setMostPopularRecycler(List<MostPopular> mostPopularDataList) {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            mostPopularView.setLayoutManager(layoutManager);
            mostPopularAdapter = new MostPopularAdapter(getActivity(), mostPopularDataList,this);
            mostPopularView.setAdapter(mostPopularAdapter);
        }

        private void setCategoryRecycler(List<Category> categoryDataList) {
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.HORIZONTAL,false);
            categoryRecyclerView.setLayoutManager(layoutManager);
            categoryAdapter = new CategoryAdapter(getActivity(),categoryDataList);
            categoryRecyclerView.setAdapter(categoryAdapter);
        }

        private void openCart(){

        }

    @Override
    public void OnItemPlusClick(String price, String quantity) {

    }

    @Override
    public void OnItemMinusClick(String price) {

    }

    @Override
    public void MostPopularClick(String name) {

    }
}

