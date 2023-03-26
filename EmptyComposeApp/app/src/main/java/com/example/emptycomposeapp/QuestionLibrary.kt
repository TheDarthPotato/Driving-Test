package com.example.emptycomposeapp

class QuestionLibrary {
    private val mQuestions = arrayOf(
        "Esta señal indica que se acerca a un cruce...",
        "¿Influye la velocidad en el campo visual del conductor?",
        "A una vía así señalizada, ¿qué vehículos no pueden acceder?",
        "Tomar un café o un té, ¿son estrategias eficaces para reducir la tasa de alcoholemia?",
        "El accidente más frecuente por el uso del teléfono móvil mientras se conduce es...",
        "¿Por qué es aconsejable circular en vías urbanas respetando en todo momento la velocidad establecida para cada tramo de vía?",
        "El efecto submarino, que en un accidente de tráfico puede provocar graves lesiones al conductor, está relacionado con...",
        "En este caso en que la señalización se contradice, prevalece la señal...",
        "En una vía urbana de sentido único, está permitido estacionar en el lado...",
        "Si aún no ha salido el sol pero existe buena visibilidad, ¿qué alumbrado debe utilizar si circula por una vía interurbana?",
        "En caso de existir niebla espesa, además de reducir la visibilidad, ¿puede disminuir la adherencia de los neumáticos sobre la calzada?",
        "¿Qué debe hacer cuando vaya a adelantar a un ciclista que lleva un pasajero?",
        "Si un agente de tráfico, desde su vehículo, le ordena detenerse mediante el encendido de un dispositivo con una luz amarilla intermitente hacia delante, ¿dónde deberá hacerlo?",
        "Si conduce con frecuencia y consume antihistamínicos para tratar una alergia respiratoria, es conveniente...",
        "Situado en un vehículo, ¿qué identifica la señal V-25 Distintivo ambiental?",
        "¿Por qué carril deberemos circular preferentemente en las calzadas de doble sentido y dos carriles?",
        "¿Pueden las bicicletas circular por la autopista?",
        "¿En cuánto tiempo se puede realizar la maniobra de parada?",
        "¿De qué manera influye el alcohol en la distancia de detención de un vehículo?",
        "¿Cuándo está bien regulado un espejo retrovisor interior?",
        "¿Cuál de éstos factores externos facilita la fatiga?",
        "¿Podrá el personal de obras regular la circulación en ausencia de Agentes de Circulación?",
        "¿Cuál es en general la velocidad máxima en vías dentro de poblado?",
        "¿Qué debe realizar el conductor de una motocicleta al sufrir una caída?",
        "En una carretera de tres carriles para cada sentido, ¿cuándo se puede circular por el carril izquierdo?",
        "¿Qué significado tienen las señales de tráfico triangulares?",
        "¿Qué debemos hacer si al realizar la maniobra de marcha atrás la situación del tráfico no es favorable?",
        "¿Puede el conductor manipular un GPS con el coche en movimiento?",
        "¿Para qué podrá utilizar el carril bus si su línea es discontinua?",
        "Cuando el alumbrado de marcha atrás esté averiado, ¿cómo indicaremos que queremos ir marcha atrás?",
        "¿Qué indican las marcas viales de color azul pintadas sobre una vía?",
        "¿Es conveniente retrasar el encendido de las luces en el crepúsculo de la tarde?",
        "¿Podrá circular por el arcén derecho de una vía una persona que circula en silla de ruedas?",
        "El consumo de sustancias estimulantes como el café, ¿resulta útil para vencer el sueño?",
        "¿Qué luz adicional se podrá encender en caso de lluvia intensa?",
        "¿Está permitido el adelantamiento en un túnel?",
        "En un turismo, ¿son necesarios los cinturones de seguridad?",
        "¿Si es de día, qué debe hacer para evitar el deslumbramiento del sol?",
        "¿Debe un conductor pararse a prestar auxilio en un accidente en el cual la ayuda ya está organizada?",
        "Los ciclistas, ¿en qué circunstancias no necesitan llevar casco mientras circulan?"
    )

    private val mImages = arrayOf(
        "imagen1",
        "",
        "imagen3",
        "",
        "",
        "",
        "",
        "imagen8",
        "",
        "",
        "",
        "",
        "",
        "",
        "imagen15",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )

    private val mChoices = arrayOf(
        arrayOf("Sin preferencia de paso.", "Con preferencia de paso.", "Con un vía estrecha"), //00
        arrayOf(
            "Sí; el campo visual disminuye al aumentar la velocidad.",                          //01
            "No.",
            "Sí; el campo visual se amplía al aumentar la velocidad."
        ),
        arrayOf("Turismos.", "Bicicletas.", "Motocicletas."),                                   //02
        arrayOf("No.", "Sí.", "No, pero masticar café en grano sí reduce la tasa de alcoholemia."),//03
        arrayOf("La salida de la vía.", "El choque frontolateral.", "Al alcance."),             //04
        arrayOf(                                                                                //05
            "Porque el motor del vehículo consume menos combustible si trabaja a altas revoluciones.",
            "Porque las multas por exceso de velocidad en vías urbanas son más caras que en vías interurbanas.",
            "Porque la mayoría de los atropellos con muerte del peatón se producen en vías urbanas."
        ),
        arrayOf(                                                                                //06
            "Una incorrecta presión de los neumáticos.",
            "Un mal uso del cinturón de seguridad.",
            "Un consumo excesivo de alcohol, medicamentos o drogas de abuso."
        ),
        arrayOf("Más restrictiva.", "Realizada con el brazo.", "Luminosa."),                    //07
        arrayOf(                                                                                //08
            "Derecho.",
            "Derecho o izquierdo, fuera de la calzada o del arcén.",
            "Derecho o izquierdo."
        ),
        arrayOf(                                                                                //09
            "El alumbrado de posición y el de corto alcance.",
            "Ninguno.",
            "El alumbrado de posición, únicamente."
        ),
        arrayOf(                                                                                //10
            "Sí, pero solamente en caso de frenar bruscamente.",
            "No, la adherencia de los neumáticos solamente disminuye cuando llueve.",
            "Sí, debido a que la niebla humedece la calzada haciéndola más deslizante."
        ),
        arrayOf(                                                                                //11
            "Aumentar la precaución ya que la bicicleta se puede desestabilizar con mayor facilidad.",
            "Aumentar la velocidad y circular lo más cerca posible del borde derecho de la calzada.",
            "Hacer señales acústicas al llegar a su altura para advertir de nuestra presencia."
        ),
        arrayOf(                                                                                //12
            "En el lado derecho de la calzada, detrás del vehículo policial.",
            "Donde no genere mayores riesgos ni molestias para el resto de usuarios.",
            "En el lado izquierdo de la calzada, delante del veh culo policial."
        ),
        arrayOf(                                                                                //13
            "Utilizar antihistamínicos no sedantes, que no producen somnolencia.",
            "Tomar alguna bebida alcohólica para evitar la aparición del sueño.",
            "Viajar al atardecer o al amanecer, ya que hay menos polen en el aire."
        ),
        arrayOf(                                                                                //14
            "Su clasificación ambiental en función de su nivel de emisiones y combustible empleado.",
            "El tipo de combustible empleado y su nivel de radiación atmosférica.",
            "Su clasificación ambiental en función de su nivel de contaminación acústica."
        ),
    arrayOf(                                                                                    //15
            "Por cualquiera de los dos aunque ralenticemos el tráfico",
            "Por el carril derecho",
            "Por el carril izquierdo"
        ),
        arrayOf(                                                                                //16
            "No, nunca",
            "Sí, en el lado derecho de la calzada y extremando la precaución",
            "Sí, conducidas por personas mayores de 14 años."
        ),
        arrayOf(                                                                                //17
            "Debe durar como mínimo 30 minutos",
            "Se puede tardar todo el tiempo que sea necesario",
            "No puede exceder de un tiempo determinado"
        ),
        arrayOf(                                                                                //18
            "Aumenta la distancia de detención",
            "El alcohol nunca influye en la distancia de detención si no en la de seguridad",
            "Disminuye la distancia de detención"
        ),
        arrayOf(                                                                                //19
            "Cuando se ve nítidamente el 50% superior de la ventanilla trasera.",
            "Cuando se ven al menos las tres cuartas partes inferiores de la ventanilla trasera.",
            "Cuando se ven todos los lados de la ventanilla trasera."
        ),
        arrayOf(                                                                                //20
            "Transportar más de tres personas en el vehículo",
            "El elevado volumen de la radio",
            "La monotonía de la carretera"
        ),
        arrayOf(                                                                                //21
            "Únicamente cuando dicha regulación se dé en autopistas",
            "No, en ningún caso",
            "Sí, podrán regular el paso de vehículo"
        ),
        arrayOf(                                                                                //22
            "60 km por hora.", "50 km por hora.", "80 km por hora."),
        arrayOf(                                                                                //23
            "Rodar el cuerpo rápidamente para provocar mayor rozamiento y detenerse lo antes posible.",
            "Deslizarse por el pavimento de forma relajada hasta quedar completamente detenido.",
            "Levantarse antes de quedar detenido por completo para evitar ser golpeado contra el suelo."
        ),
        arrayOf(                                                                                //24
            "Nunca.",
            "Sólo para avanzar.",
            "Cuando los otros carriles están ocupados y no dificulto el paso de vehículos que circulan detrás."
        ),
        arrayOf(                                                                                //25
            "Peligro", "Obligación", "Restricción"),
        arrayOf(                                                                                //26
            "Abstenerse de realizar la maniobra y esperar al menos 24 horas.",
            "Realizar la maniobra de todas formas.",
            "Abstenerse de realizar la maniobra y esperar el momento oportuno"
        ),
        arrayOf(                                                                                //27
            "No, no está permitido",
            "Sí, pero únicamente si se toca la pantalla",
            "Sí y debe llevarlo justamente delante del volante aunque tape la visión"
        ),
        arrayOf(                                                                                //28
            "Únicamente para girar",
            "No se podrá utilizar el carril bus para efectuar ninguna maniobra",
            "Para realizar cualquier maniobra que no sea parar, estacionar, cambiar de sentido o adelantar"
        ),
        arrayOf(                                                                                //29
            "Con el brazo extendido y la palma de la mano hacia atrás.",
            "Advirtiéndolo con el claxon.",
            "Moviendo el brazo de arriba a abajo."
        ),
        arrayOf(                                                                                //30
            "Prohibido parar o estacionar.",
            "Duración de estacionamiento limitada.",
            "Zona reservada para carga y descarga."
        ),
        arrayOf(                                                                                //31
            "Sí, es recomendable para ahorrar energía.",
            "Únicamente deberán retrasarlo los camiones por su menor riesgo de accidente.",
            "No, nunca."
        ),
        arrayOf(                                                                                //32
            "Sí, siempre con mucha atención y tomando las medidas de precaución necesarias.",
            "No.",
            "Únicamente en vías dentro de poblado."
        ),
        arrayOf(                                                                                //33
            "Sí, pueden resultar útiles porque ayudan a mantener la atención del conductor a largo plazo.",
            "No, en ningún caso.",
            "Si, pueden resultar útiles a corto plazo pero cuando pasan sus efectos se puede producir un efecto rebote."
        ),
        arrayOf(                                                                                //34
            "La luz antiniebla trasera únicamente",
            "Las luces de emergencia y la luz antiniebla delantera",
            "La luz antiniebla delantera"
        ),
        arrayOf(                                                                                //35
            "Sí, si existe más de un carril para cada sentido de la marcha.",
            "No.",
            "Sí, si cada sentido de la marcha está separados."
        ),
        arrayOf(                                                                                //36
            "No, si el uso del cinturón molesta o quita libertad de movimientos.",
            "Sí, excepto para el conductor si realiza una maniobra de marcha atrás o de estacionamiento.",
            "Sí, excepto en los taxis."
        ),
        arrayOf(                                                                                //37
            "Protegerse con los parasoles",
            "Mirar de frente al sol y posteriormente a la carretera",
            "Protegerse con gafas graduadas de cristal transparente"
        ),
        arrayOf(                                                                                //38
            "Sí, pero únicamente en vías urbanas sin poste SOS",
            "Sí, debe detenerse y colaborar siempre",
            "No, si no está implicado debe continuar la marcha"
        ),
        arrayOf(                                                                                //39
            "En pendientes ascendentes y descendentes prolongadas.",
            "En largas pendientes ascendentes.",
            "En vías interurbanas."
        )
    )
    private val mCorrectAnswers = arrayOf(
        "Con preferencia de paso.",                                                             //00
        "Sí; el campo visual disminuye al aumentar la velocidad.",                              //01
        "Bicicletas.",                                                                          //02
        "No.",                                                                                  //03
        "La salida de la vía.",                                                                 //04
        "Porque la mayoría de los atropellos con muerte del peatón se producen en vías urbanas.",//05
        "Un mal uso del cinturón de seguridad.",                                                //06
        "Realizada con el brazo.",                                                              //07
        "Derecho o izquierdo.",                                                                 //08
        "El alumbrado de posición y el de corto alcance.",                                      //09
        "Sí, debido a que la niebla humedece la calzada haciéndola más deslizante.",            //10
        "Aumentar la precaución ya que la bicicleta se puede desestabilizar con mayor facilidad.",//11
        "Donde no genere mayores riesgos ni molestias para el resto de usuarios.",              //12
        "Utilizar antihistamínicos no sedantes, que no producen somnolencia.",                  //13
        "Su clasificación ambiental en función de su nivel de emisiones y combustible empleado.",//14
        "Por el carril derecho",                                                                //15
        "No, nunca",                                                                            //16
        "No puede exceder de un tiempo determinado",                                            //17
        "Aumenta la distancia de detención",                                                    //18
        "Cuando se ven todos los lados de la ventanilla trasera.",                              //19
        "La monotonía de la carretera",                                                         //20
        "Sí, podrán regular el paso de vehículo",                                               //21
        "50 km por hora.",                                                                      //22
        "Deslizarse por el pavimento de forma relajada hasta quedar completamente detenido.",   //23
        "Cuando los otros carriles están ocupados y no dificulto el paso de vehículos que circulan detrás.",//24
        "Peligro",                                                                              //25
        "Abstenerse de realizar la maniobra y esperar el momento oportuno",                     //26
        "No, no está permitido",                                                                //27
        "Para realizar cualquier maniobra que no sea parar, estacionar, cambiar de sentido o adelantar",//28
        "Con el brazo extendido y la palma de la mano hacia atrás.",                            //29
        "Duración de estacionamiento limitada.",                                                //30
        "No, nunca.",                                                                           //31
        "Sí, siempre con mucha atención y tomando las medidas de precaución necesarias.",       //32
        "Si, pueden resultar útiles a corto plazo pero cuando pasan sus efectos se puede producir ",//33
        "La luz antiniebla delantera",                                                          //34
        "Sí, si existe más de un carril para cada sentido de la marcha.",                       //35
        "Sí, excepto para el conductor si realiza una maniobra de marcha atrás o de estacionamiento.",//36
        "Protegerse con los parasoles",                                                         //37
        "No, si no está implicado debe continuar la marcha",                                    //38
        "En largas pendientes ascendentes."                                                     //39
    )

    fun getQuestion(a: Int): String {
        return mQuestions[a]
    }

    fun getImage(a: Int): String {
        return mImages[a]
    }

    fun getChoice1(a: Int): String {
        return mChoices[a][0]
    }

    fun getChoice2(a: Int): String {
        return mChoices[a][1]
    }

    fun getChoice3(a: Int): String {
        return mChoices[a][2]
    }

    fun getAnswer(a: Int): String {
        return mCorrectAnswers[a]
    }
}