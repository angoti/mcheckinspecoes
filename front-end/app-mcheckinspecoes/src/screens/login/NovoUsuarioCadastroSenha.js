import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, ScrollView, Keyboard } from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';

const CadastroSenhaScreen = () => {
  const [senha, setSenha] = useState('');
  const [senhaConfirmar, setSenhaConfirmar] = useState('');
  const [mostrarSenha, setMostrarSenha] = useState(false);
  const [mostrarSenhaConfirmar, setMostrarSenhaConfirmar] = useState(false);

  const handleVoltar = () => {
    // Lógica para cancelar o cadastro
  };

  const handleAvancar = () => {
    // Lógica para avançar no cadastro
  };

  const toggleMostrarSenha = () => {
    setMostrarSenha(!mostrarSenha);
  };

  const toggleMostrarSenhaConfirmar = () => {
    setMostrarSenhaConfirmar(!mostrarSenhaConfirmar);
  };

  return (
    <ScrollView contentContainerStyle={styles.container} keyboardShouldPersistTaps="handled">
      <Text style={styles.logo}>MCheck Inspeções</Text>
      <View style={styles.centerContainer}>
        <Text style={styles.title}>Cadastro</Text>

        <View style={styles.inputView}>
          <Icon name="lock" size={20} color="#003f5c" style={styles.inputIcon} />
          <TextInput
            style={styles.inputText}
            placeholder="Senha"
            placeholderTextColor="#003f5c"
            value={senha}
            onChangeText={setSenha}
            secureTextEntry={!mostrarSenha}
          />
          <TouchableOpacity style={styles.eyeIcon} onPress={toggleMostrarSenha}>
            <Icon name={mostrarSenha ? 'visibility' : 'visibility-off'} size={20} color="#003f5c" />
          </TouchableOpacity>
        </View>

        <View style={styles.inputView}>
          <Icon name="lock" size={20} color="#003f5c" style={styles.inputIcon} />
          <TextInput
            style={styles.inputText}
            placeholder="Confirme sua senha"
            placeholderTextColor="#003f5c"
            value={senhaConfirmar}
            onChangeText={setSenhaConfirmar}
            secureTextEntry={!mostrarSenhaConfirmar}
          />
          <TouchableOpacity style={styles.eyeIcon} onPress={toggleMostrarSenhaConfirmar}>
            <Icon name={mostrarSenhaConfirmar ? 'visibility' : 'visibility-off'} size={20} color="#003f5c" />
          </TouchableOpacity>
        </View>

        <View style={styles.passoContainer}>
          <Text style={styles.passo}>Passo 2 de 2</Text>
        </View>

        <View style={styles.buttonContainer}>
          <TouchableOpacity style={styles.cancelButton} onPress={handleVoltar}>
            <Text style={styles.buttonText}>Voltar</Text>
          </TouchableOpacity>

          <TouchableOpacity style={styles.avancarButton} onPress={handleAvancar}>
            <Text style={styles.buttonText}>Avançar</Text>
          </TouchableOpacity>
        </View>
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flexGrow: 1,
    alignItems: 'center',
    paddingTop: 50,
    paddingBottom: 20,
  },
  centerContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    width: '100%',
    paddingHorizontal: 20,
  },
  logo: {
    fontSize: 30,
    fontWeight: 'bold',
    marginBottom: 20,
    position: 'absolute',
    top: 0,
    left: 0,
    right: 0,
    textAlign: 'center',
    paddingTop: 50,
    backgroundColor: 'white',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  inputView: {
    width: '100%',
    backgroundColor: 'white',
    borderRadius: 10,
    height: 50,
    marginBottom: 20,
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: 10,
    borderWidth: 1,
  },
  inputIcon: {
    marginRight: 10,
  },
  inputText: {
    flex: 1,
    height: 50,
    color: 'black',
  },
  eyeIcon: {
    marginLeft: 10,
  },
  passoContainer: {
    alignSelf: 'flex-end',
    marginRight: 10,
  },
  passo: {
    color: '#3cb371',
    fontWeight: '700',
    textAlign: 'right',
  },
  buttonContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: 30,
  },
  cancelButton: {
    flex: 1,
    backgroundColor: '#c4c4c4',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    marginRight: 10,
  },
  avancarButton: {
    flex: 1,
    backgroundColor: '#3cb371',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    marginLeft: 10,
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
  },
});

export default CadastroSenhaScreen;
