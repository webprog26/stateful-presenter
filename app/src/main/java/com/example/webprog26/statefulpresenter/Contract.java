package com.example.webprog26.statefulpresenter;

/**
 * Created by webprog26 on 11.03.18.
 */

public interface Contract {

    interface View extends BaseView {
        void setProgressbarPosition(final int position);
    }

    interface State extends BaseState {
        int getLastProgressBarPosition();
    }

    interface Model extends BaseModel {
        int provideProgressBarPosition();

        void updateLastPosition();
    }

    interface Presenter extends BaseStatefulPresenter<View, State> {
        void onProgressBarPositionChanged(final int position);
    }
}
