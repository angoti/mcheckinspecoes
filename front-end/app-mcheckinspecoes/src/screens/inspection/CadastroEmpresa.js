import React, { useState } from "react";
import { StyleSheet, Text, TextInput, View, TouchableOpacity } from "react-native";
import { SafeAreaProvider } from 'react-native-safe-area-context';

const CadastroEmpresa = ({ navigation }) => {
  const [empresa, setEmpresa] = useState("Ex.: Wagner Magri Consultoria");
  const [inspetor, setInspetor] = useState("Ex.: Wagner Magri");
  const [telefone, setTelefone] = useState("Ex.: 99999999999");
  const [email, setEmail] = useState("Ex.: wagner.magri@gmail.com");

  const clearDefaultValue = (stateFunction, defaultValue) => {
    if (stateFunction() === "") {
      stateFunction(defaultValue);
    }
  };

  return (
    <SafeAreaProvider>
      <View style={styles.container}>
        <Text style={styles.title}>Cadastro da Empresa</Text>
        <View>
          <View style={styles.inputContainer}>
            <Text>Nome da empresa</Text>
            <TextInput
              style={styles.textInput}
              value={empresa}
              onFocus={() =>
                clearDefaultValue(setEmpresa, "Ex.: Wagner Magri Consultoria")
              }
              onBlur={() =>
                clearDefaultValue(setEmpresa, "Ex.: Wagner Magri Consultoria")
              }
              onChangeText={(text) => setEmpresa(text)}
            />
          </View>
          <View style={styles.inputContainer}>
            <Text>Nome do inspetor</Text>
            <TextInput
              style={styles.textInput}
              value={inspetor}
              onFocus={() => clearDefaultValue(setInspetor, "Ex.: Wagner Magri")}
              onBlur={() => clearDefaultValue(setInspetor, "Ex.: Wagner Magri")}
              onChangeText={(text) => setInspetor(text)}
            />
          </View>
          <View style={styles.inputContainer}>
            <Text>Telefone do inspetor</Text>
            <TextInput
              style={styles.textInput}
              value={telefone}
              onFocus={() => clearDefaultValue(setTelefone, "Ex.: 99999999999")}
              onBlur={() => clearDefaultValue(setTelefone, "Ex.: 99999999999")}
              onChangeText={(text) => setTelefone(text)}
            />
          </View>
          <View style={styles.inputContainer}>
            <Text>Email do inspetor</Text>
            <TextInput
              style={styles.textInput}
              value={email}
              onFocus={() =>
                clearDefaultValue(setEmail, "Ex.: wagner.magri@gmail.com")
              }
              onBlur={() =>
                clearDefaultValue(setEmail, "Ex.: wagner.magri@gmail.com")
              }
              onChangeText={(text) => setEmail(text)}
            />
          </View>
        </View>
        <View>
          <Text style={styles.passo}>Passo 1 de 3</Text>
        </View>
        <View style={styles.buttonContainer}>
          <TouchableOpacity
            style={styles.button}
            onPress={() => navigation.goBack()}
          >
            <Text style={styles.buttonText}>Voltar</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={styles.button}
            onPress={() => navigation.navigate('CadastroInspecao')}
          >
            <Text style={styles.buttonText}>Avançar</Text>
          </TouchableOpacity>
        </View>
      </View>
    </SafeAreaProvider>
  );
};
export default CadastroEmpresa;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "flex-start",
    paddingHorizontal: 20,
    backgroundColor: "white"
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    marginVertical: 40,
    textAlign: "center",
    color: "#3cb371",
    fontWeight: "700"
  },
  inputContainer: {
    marginBottom: 20,
    borderWidth: 1,
    borderColor: "gray",
    borderRadius: 5,
    paddingHorizontal: 10,
  },
  buttonContainer: {
    flexDirection: "row",
    justifyContent: "center",
    marginTop: 50,
  },
  button: {
    backgroundColor: "#3cb371",
    paddingVertical: 15,
    paddingHorizontal: 20,
    marginHorizontal: 10,
    height: 50,
    width: 150,
    borderRadius: 10
  },
  buttonText: {
    color: "white",
    textAlign: "center",
    fontSize: 18,
  },
  passo: {
    color: "#3cb371",
    fontWeight: "700",
    textAlign: "right"
  }
});
