package it.studio_java8.esercitazioni.validazione_persona_type;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class PersonaType {

    private String nome;
    private String codiceFiscale;
    private String cognome;
    private String codSesso;
    private String desSesso;
    private LocalDate dataNascita;
    private String codStatoNascita;
    private String desStatoNascita;
    private String codRegioneNascita;
    private String desRegioneNascita;
    private String codProvinciaNascita;
    private String desProvinciaNascita;
    private String codComuneNascita;
    private String desComuneNascita;
    private LocalDate dataPrimaAssunzionePA;
    private String codStatoCivile;
    private String desStatoCivile;
    private String codProfilo;
    private String desProfilo;
    private String codCittadinanza;
    private String desCittadinanza;
    private String codStatoResidenza;
    private String desStatoResidenza;
    private String codRegioneResidenza;
    private String desRegioneResidenza;
    private String codProvinciaResidenza;
    private String desProvinciaResidenza;
    private String codComuneResidenza;
    private String desComuneResidenza;
    private String indirizzoResidenza;
    private String capResidenza;
    private String codStatoDomicilio;
    private String descStatoDomicilio;
    private String codRegioneDomicilio;
    private String desRegioneDomicilio;
    private String codProvinciaDomicilio;
    private String desProvinciaDomicilio;
    private String codComuneDomicilio;
    private String desComuneDomicilio;
    private String indirizzoDomicilio;
    private String capDomicilio;
    private String telefonoAbitazione;
    private String telefonoMobile;
    private String indirizzoEmail;
    private String indirizzoPEC;
    private String gradeID;
    private String codAreaEconomicaLivInq;
    private String desAreaEconomicaLivInq;
    private String codInqGiuridicoLivInq;
    private String desInqGiuridicoLivInq;
    private String codInqEconomicoLivInq;
    private String desInqEconomicoLivInq;
    private String codProfiloProfessionaleLivInq;
    private String desProfiloProfessionaleLivInq;
    private Boolean validoPerCMDIN;
    private Boolean validoPerCMDOUT;
    private String idSoggetto;
    private String idRapportoLavoro;

    public PersonaType(String nome,
            String cognome,
            String codiceFiscale,
            String codSesso,
            String desSesso,
            LocalDate dataNascita,
            String codStatoNascita,
            String desStatoNascita,
            String codRegioneNascita,
            String desRegioneNascita,
            String codProvinciaNascita,
            String desProvinciaNascita,
            String codComuneNascita,
            String desComuneNascita,
            LocalDate dataPrimaAssunzionePA,
            String codStatoCivile,
            String desStatoCivile,
            String codProfilo,
            String desProfilo,
            String codCittadinanza,
            String desCittadinanza,
            String codStatoResidenza,
            String desStatoResidenza,
            String codRegioneResidenza,
            String desRegioneResidenza,
            String codProvinciaResidenza,
            String desProvinciaResidenza,
            String codComuneResidenza,
            String desComuneResidenza,
            String indirizzoResidenza,
            String capResidenza,
            String codStatoDomicilio,
            String descStatoDomicilio,
            String codRegioneDomicilio,
            String desRegioneDomicilio,
            String codProvinciaDomicilio,
            String desProvinciaDomicilio,
            String codComuneDomicilio,
            String desComuneDomicilio,
            String indirizzoDomicilio,
            String capDomicilio,
            String telefonoAbitazione,
            String telefonoMobile,
            String indirizzoEmail,
            String indirizzoPEC,
            String gradeID,
            String codAreaEconomicaLivInq,
            String desAreaEconomicaLivInq,
            String codInqGiuridicoLivInq,
            String desInqGiuridicoLivInq,
            String codInqEconomicoLivInq,
            String desInqEconomicoLivInq,
            String codProfiloProfessionaleLivInq,
            String desProfiloProfessionaleLivInq,
            Boolean validoPerCMDIN,
            Boolean validoPerCMDOUT,
            String idSoggetto,
            String idRapportoLavoro) {
        super();
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.cognome = cognome;
        this.codSesso = codSesso;
        this.desSesso = desSesso;
        this.dataNascita = dataNascita;
        this.codStatoNascita = codStatoNascita;
        this.desStatoNascita = desStatoNascita;
        this.codRegioneNascita = codRegioneNascita;
        this.desRegioneNascita = desRegioneNascita;
        this.codProvinciaNascita = codProvinciaNascita;
        this.desProvinciaNascita = desProvinciaNascita;
        this.codComuneNascita = codComuneNascita;
        this.desComuneNascita = desComuneNascita;
        this.dataPrimaAssunzionePA = dataPrimaAssunzionePA;
        this.codStatoCivile = codStatoCivile;
        this.desStatoCivile = desStatoCivile;
        this.codProfilo = codProfilo;
        this.desProfilo = desProfilo;
        this.codCittadinanza = codCittadinanza;
        this.desCittadinanza = desCittadinanza;
        this.codStatoResidenza = codStatoResidenza;
        this.desStatoResidenza = desStatoResidenza;
        this.codRegioneResidenza = codRegioneResidenza;
        this.desRegioneResidenza = desRegioneResidenza;
        this.codProvinciaResidenza = codProvinciaResidenza;
        this.desProvinciaResidenza = desProvinciaResidenza;
        this.codComuneResidenza = codComuneResidenza;
        this.desComuneResidenza = desComuneResidenza;
        this.indirizzoResidenza = indirizzoResidenza;
        this.capResidenza = capResidenza;
        this.codStatoDomicilio = codStatoDomicilio;
        this.descStatoDomicilio = descStatoDomicilio;
        this.codRegioneDomicilio = codRegioneDomicilio;
        this.desRegioneDomicilio = desRegioneDomicilio;
        this.codProvinciaDomicilio = codProvinciaDomicilio;
        this.desProvinciaDomicilio = desProvinciaDomicilio;
        this.codComuneDomicilio = codComuneDomicilio;
        this.desComuneDomicilio = desComuneDomicilio;
        this.indirizzoDomicilio = indirizzoDomicilio;
        this.capDomicilio = capDomicilio;
        this.telefonoAbitazione = telefonoAbitazione;
        this.telefonoMobile = telefonoMobile;
        this.indirizzoEmail = indirizzoEmail;
        this.indirizzoPEC = indirizzoPEC;
        this.gradeID = gradeID;
        this.codAreaEconomicaLivInq = codAreaEconomicaLivInq;
        this.desAreaEconomicaLivInq = desAreaEconomicaLivInq;
        this.codInqGiuridicoLivInq = codInqGiuridicoLivInq;
        this.desInqGiuridicoLivInq = desInqGiuridicoLivInq;
        this.codInqEconomicoLivInq = codInqEconomicoLivInq;
        this.desInqEconomicoLivInq = desInqEconomicoLivInq;
        this.codProfiloProfessionaleLivInq = codProfiloProfessionaleLivInq;
        this.desProfiloProfessionaleLivInq = desProfiloProfessionaleLivInq;
        this.validoPerCMDIN = validoPerCMDIN;
        this.validoPerCMDOUT = validoPerCMDOUT;
        this.idSoggetto = idSoggetto;
        this.idRapportoLavoro = idRapportoLavoro;
    }
}
