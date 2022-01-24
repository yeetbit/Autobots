package dev.obit.tools.autobots.model;

import javafx.collections.ObservableList;

public interface NestedData<T> {
    /**
     * The children collection, which represents the recursive nature of the hierarchy.
     * Each child is again a {@link NestedData}.
     *
     * @return A list of children.
     */
    ObservableList<T> getChildren();

}
