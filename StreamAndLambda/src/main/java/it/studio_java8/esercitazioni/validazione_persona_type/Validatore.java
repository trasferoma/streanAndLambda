package it.studio_java8.esercitazioni.validazione_persona_type;

import java.util.HashMap;
import java.util.Map;

public class Validatore {
    private static final String MESSAGGIO_PRELIMINARE =
            "<p>L'anagrafica selezionata è censita su HR Infinity ma non riporta alcune informazioni obbligatorie per l'inserimento della richiesta. Si prega di aggiornare l'anagrafica su HR Infinity per poter procedere con l'inserimento della richiesta di comando.</p><p>I campi mancanti sono: ";

    private StringBuilder campiMancanti = new StringBuilder();

    public boolean isValidFromZucchetti(PersonaType sorgente) {

        Map<String, Object> daValidare = new HashMap<>();

        daValidare.put("nome", sorgente.getNome());
        daValidare.put("codiceFiscale", sorgente.getCodiceFiscale());
        daValidare.put("cognome", sorgente.getCognome());
        daValidare.put("codSesso", sorgente.getCodSesso());
        daValidare.put("desSesso", sorgente.getDesSesso());
        daValidare.put("dataNascita", sorgente.getDataNascita());
        daValidare.put("codStatoNascita", sorgente.getCodStatoNascita());
        daValidare.put("desStatoNascita", sorgente.getDesStatoNascita());
        daValidare.put("codProfilo", sorgente.getCodProfilo());
        daValidare.put("desProfilo", sorgente.getDesProfilo());
        daValidare.put("validoCmdIn", sorgente.getValidoPerCMDIN());
        daValidare.put("validoCmdOut", sorgente.getValidoPerCMDOUT());

        String messaggiErrore = daValidare.entrySet()
                .stream()
                .filter(e -> e.getValue() == null)
                .map(e -> getMessaggioErrore(e.getKey()))
                .reduce("", String::concat);

        caricaMessaggiDiErrore(messaggiErrore);

        return isErroriPresenti(messaggiErrore);
    }

    private String getMessaggioErrore(String nomeCampo) {
        return "<li>" + nomeCampo + "</li>";
    }

    private void caricaMessaggiDiErrore(String messaggiErrore) {

        if (isErroriPresenti(messaggiErrore)) {
            return;
        }

        campiMancanti.append("<ul>");
        campiMancanti.append(messaggiErrore);
        campiMancanti.append("</ul>");
    }

    private boolean isErroriPresenti(String messaggiErrore) {
        return messaggiErrore.length() > 0;
    }

    public String getMessaggioCompleto() {
        return MESSAGGIO_PRELIMINARE + campiMancanti.toString();
    }
}
