package com.back.Felipe.Enum;

public enum StatusEnum {
    novo,
    andamento,
    resolvido,
    aprovado,
    desaprovado,
    fechado;

    public static  StatusEnum getStatus(String status){
        switch (status){
            case "novo": return  novo;
            case "resolvido": return  resolvido;
            case "aprovado": return  aprovado;
            case "andamento":  return  andamento;
            case  "desaprovado": return  desaprovado;
            case "fechado": return fechado;
            case null, default: return  novo;

        }
    }
}
