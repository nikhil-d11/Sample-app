package com.example.sampleapp.databinding;

import android.provider.ContactsContract;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Calculator extends BaseObservable {
    String num1="1",num2="1",add,substract,multiply,divide;


    public Calculator() {
    }


    @Bindable
    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
    @Bindable
    public String getSubstract() {
        return substract;
    }

    public void setSubstract(String substract) {
        this.substract = substract;
    }
    @Bindable
    public String getMultiply() {
        return multiply;
    }

    public void setMultiply(String multiply) {
        this.multiply = multiply;
    }

    @Bindable
    public String getDivide() {
        return divide;
    }

    public void setDivide(String divide) {
        this.divide = divide;
    }

    @Bindable
    public String getNum1() {
        return num1;
    }


    public void setNum1(String num1) {
        this.num1 = num1;

        try {
            this.add= String.valueOf(Integer.parseInt(num1)+Integer.parseInt(num2));
            this.substract= String.valueOf(Integer.parseInt(num1)-Integer.parseInt(num2));
            this.multiply= String.valueOf(Integer.parseInt(num1)*Integer.parseInt(num2));
            if(Integer.parseInt(num2)!=0){
                this.divide= String.valueOf(Integer.parseInt(num1)/Integer.parseInt(num2));
            }else {
                this.divide="NULL";
            }

            notifyPropertyChanged(BR.add);
            notifyPropertyChanged(BR.substract);
            notifyPropertyChanged(BR.multiply);
            notifyPropertyChanged(BR.divide);
        }catch (NumberFormatException e){

        }

        notifyPropertyChanged(BR.num1);
    }


    @Bindable
    public String getNum2() {
        return num2;
    }
    public void setNum2(String num2) {
        this.num2 = num2;

        try {
            this.add= String.valueOf(Integer.parseInt(num1)+Integer.parseInt(num2));
            this.substract= String.valueOf(Integer.parseInt(num1)-Integer.parseInt(num2));
            this.multiply= String.valueOf(Integer.parseInt(num1)*Integer.parseInt(num2));

            if(Integer.parseInt(num2)!=0){
                this.divide= String.valueOf(Integer.parseInt(num1)/Integer.parseInt(num2));
            }else {
                this.divide="NULL";
            }

            notifyPropertyChanged(BR.add);
            notifyPropertyChanged(BR.substract);
            notifyPropertyChanged(BR.multiply);
            notifyPropertyChanged(BR.divide);

        }catch (NumberFormatException e){

        }

        notifyPropertyChanged(BR.num2);

    }


}
