
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FAptitud  extends FitnessFunction{

    private final int montoingresado;
    public static final int MAX_MONEDAS=1000;

    public FAptitud(int monto)
    {
        montoingresado = monto;
    }

    public double evaluate(IChromosome cromosoma)
    {
        int tmonedas = getTotalMonedas(cromosoma);
        int tdolares = getTotalMonto(cromosoma);

        int diferenciamonto = Math.abs(montoingresado - tdolares);

        if (diferenciamonto != 0 )
            return 0.0d;

        return MAX_MONEDAS - tmonedas;
    }


    public static int getNumdeMonedas(IChromosome cromosoma, int numerogen)
    {
        Integer numeromoneda = (Integer) cromosoma.getGene(numerogen).getAllele();

        return numeromoneda.intValue();
    }

    public static int getTotalMonedas(IChromosome cromosoma)
    {
        int totalmone=0;
        for (int i=0;i<=5;i++)
        {
            totalmone += getNumdeMonedas(cromosoma,i);
        }

        return totalmone;
    }


    public static int getTotalMonto(IChromosome cromosoma)
    {
        int moneda1dolar = getNumdeMonedas(cromosoma,0);
        int moneda50centavos = getNumdeMonedas(cromosoma,1);
        int moneda25centavos = getNumdeMonedas(cromosoma,2);
        int moneda10centavos = getNumdeMonedas(cromosoma,3);
        int moneda5centavos = getNumdeMonedas(cromosoma,4);
        int moneda1centavo = getNumdeMonedas(cromosoma,5);

        int total = (moneda1dolar * 100) + (moneda50centavos * 50) + (moneda25centavos * 25) + (moneda10centavos * 10)+ (moneda5centavos *5)+ (moneda1centavo *1);

        return total;
    }



}
