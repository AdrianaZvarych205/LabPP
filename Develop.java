package com.company;

import com.company.Commands.*;

public class Develop {
    Command _CreateNewGameRoom;
    Command _CreateNewToy;
    Command _ListOfToys;
    Command _OverallWeightBySize;
    Command _OverallValueInPrice;
    Command _SortToysByValue;
    Command _SortToysByWeight;
    Command _PricecRange;

    public Develop(Command CreateNewGameRoom, Command CreateNewToy,
                   Command ListOfToys,
                   Command OverallWeightBySize, Command OverallValueInPrice,
                   Command SortToysByValue,
                   Command SortToysByWeight,
                   Command PricecRange
    ) {
        this._CreateNewGameRoom = CreateNewGameRoom;
        this._CreateNewToy = CreateNewToy;
        this._ListOfToys = ListOfToys;
        this._OverallWeightBySize = OverallWeightBySize;
        this._OverallValueInPrice = OverallValueInPrice;
        this._SortToysByValue = SortToysByValue;
        this._SortToysByWeight = SortToysByWeight;
        this._PricecRange = PricecRange;

    }

    public void CreateNewGameRoom() {
        this._CreateNewGameRoom.execute();
    }

    public void CreateNewToy() {
        this._CreateNewToy.execute();
    }

    public void ListOfToys() {
        this._ListOfToys.execute();
    }

    public void OverallWeightBySize() {
        this._OverallWeightBySize.execute();
    }

    public void OverallValueInPrice() {
        this._OverallValueInPrice.execute();
    }

    public void SortToysByValue() {
        this._SortToysByValue.execute();
    }

    public void SortToysByWeight() {
        this._SortToysByWeight.execute();
    }

    public void PricecRange() {
        this._PricecRange.execute();
    }
}
