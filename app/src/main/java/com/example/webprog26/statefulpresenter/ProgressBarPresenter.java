package com.example.webprog26.statefulpresenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by webprog26 on 11.03.18.
 */

public class ProgressBarPresenter implements Contract.Presenter {

    @Nullable
    private Contract.View view;

    private Contract.Model model = new Contract.Model() {

        private final Repository repository = App.getRepositoryInstance();

        @Override
        public int provideProgressBarPosition() {
            return repository.getSavedPosition();
        }

        @Override
        public void updateLastPosition() {
            repository.savePosition(lastPosition);
        }
    };

    private int lastPosition;

    @Override
    public void subscribe(@NonNull Contract.View view) {
        subscribe(view, null);
    }


    @Override
    public void unsubscribe() {
        model.updateLastPosition();
        view = null;
    }

    @Override
    public void subscribe(@NonNull Contract.View view, @Nullable Contract.State state) {
        this.view = view;

        final int retrievedPosition;

        if (state != null) {
            retrievedPosition = state.getLastProgressBarPosition();
        } else {
            retrievedPosition = model.provideProgressBarPosition();
        }

        view.setProgressbarPosition(retrievedPosition);
        view.updateTitle(String.valueOf(retrievedPosition));
    }

    @NonNull
    @Override
    public Contract.State getState() {
        return new ProgressBarState(lastPosition);
    }

    @Override
    public void onProgressBarPositionChanged(int position) {
        lastPosition = position;

        if (view != null) {
            view.updateTitle(String.valueOf(position));
        }
    }
}
