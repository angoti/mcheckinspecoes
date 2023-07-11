import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet } from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';

const CadastroScreen = () => {
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');

  const handleCancelar = () => {
    // Lógica para cancelar o cadastro
  };

  const handleAvancar = () => {
    // Lógica para avançar no cadastro
  };

  return (
    <View style={styles.container}>
      <Text style={styles.logo}>MCheck Inspeções</Text>
      <Text style={styles.title}>Cadastro</Text>

      <View style={styles.inputView}>
        <Icon name="person" size={20} color="#003f5c" style={styles.inputIcon} />
        <TextInput
          style={styles.inputText}
          placeholder="Nome Completo"
          placeholderTextColor="#003f5c"
          value={nome}
          onChangeText={setNome}
        />
      </View>

      <View style={styles.inputView}>
        <Icon name="email" size={20} color="#003f5c" style={styles.inputIcon} />
        <TextInput
          style={styles.inputText}
          placeholder="Email"
          placeholderTextColor="#003f5c"
          value={email}
          onChangeText={setEmail}
        />
      </View>

      <View style={styles.passoContainer}>
        <Text style={styles.passo}>Passo 1 de 2</Text>
      </View>

      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.cancelButton} onPress={handleCancelar}>
          <Text style={styles.buttonText}>Cancelar</Text>
        </TouchableOpacity>

        <TouchableOpacity style={styles.avancarButton} onPress={handleAvancar}>
          <Text style={styles.buttonText}>Avançar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    paddingHorizontal: 20,
  },
  logo: {
    position: 'absolute',
    top: 0,
    fontSize: 30,
    fontWeight: 'bold',
    marginTop: 50
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
    marginTop: 30
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
    borderWidth: 1
  },
  inputIcon: {
    marginRight: 10,
  },
  inputText: {
    flex: 1,
    height: 50,
    color: 'black',
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

export default CadastroScreen;
