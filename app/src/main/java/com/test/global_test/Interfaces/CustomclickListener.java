package com.test.global_test.Interfaces;

/**
 * Created by vinay on 4/11/2018.
 */

public interface CustomclickListener extends BaseRecyclerViewListener {


    interface onRecyclerItemClick extends BaseRecyclerViewListener {
        void onItemClicked(int position);
    }

    interface onNearByShopClickListener extends BaseRecyclerViewListener {
        void onNearbyShopClick(int position);
    }

    interface onCategoryClick extends BaseRecyclerViewListener {
        void onClickCategory(int position);
    }

    interface onFeatureHotelClick extends BaseRecyclerViewListener {
        void onHotelClick(int position);
    }

    interface hotelItemClickListener extends BaseRecyclerViewListener {

        void onHotelItemClick(int pos);

        void onFavoriteClick(int pos);

    }

    interface viewPagerClick {
        void onViewPageItemClick(int position);
    }


}
