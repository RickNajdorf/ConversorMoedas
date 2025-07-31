package Service;

import com.google.gson.annotations.SerializedName;

public record ConversionRates(@SerializedName("USD") double dolar,
                              @SerializedName("ARS") double pesoArgentino,
                              @SerializedName("BRL") double real,
                              @SerializedName("COP") double pesoColombiano ) {
}
