import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet } from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';

const CadastroSenhaScreen = () => {
  const [nome, setNome] = useState('');
  const [telefone, setTelefone] = useState('');
  const [email, setEmail] = useState('');

  const [nomeEditavel, setNomeEditavel] = useState(false);
  const [telefoneEditavel, setTelefoneEditavel] = useState(false);
  const [emailEditavel, setEmailEditavel] = useState(false);

  const handleEditar = () => {
    setNomeEditavel(true);
    setTelefoneEditavel(true);
    setEmailEditavel(true);
  };

  const handleCancelar = () => {
    setNome('');
    setTelefone('');
    setEmail('');
    setNomeEditavel(false);
    setTelefoneEditavel(false);
    setEmailEditavel(false);
  };

  const handleSalvar = () => {
    // Lógica para chamar a API e atualizar o banco de dados
  };

  return (
    <View style={styles.container}>
      <Text style={[styles.logo, { marginTop: 50 }]}>MCheck Inspeções</Text>
      <Text style={styles.title}>Olá, Wagner</Text>

      <View style={[styles.inputView, !nomeEditavel && styles.disabledInput]}>
        <Icon name="person" size={20} color="#003f5c" style={styles.inputIcon} />
        <TextInput
          style={styles.inputText}
          placeholder="Nome Completo"
          placeholderTextColor="#003f5c"
          value={nome}
          onChangeText={setNome}
          editable={nomeEditavel}
        />
      </View>

      <View style={[styles.inputView, !telefoneEditavel && styles.disabledInput]}>
        <Icon name="phone" size={20} color="#003f5c" style={styles.inputIcon} />
        <TextInput
          style={styles.inputText}
          placeholder="Telefone"
          placeholderTextColor="#003f5c"
          value={telefone}
          onChangeText={setTelefone}
          editable={telefoneEditavel}
        />
      </View>

      <View style={[styles.inputView, !emailEditavel && styles.disabledInput]}>
        <Icon name="email" size={20} color="#003f5c" style={styles.inputIcon} />
        <TextInput
          style={styles.inputText}
          placeholder="Email"
          placeholderTextColor="#003f5c"
          value={email}
          onChangeText={setEmail}
          editable={emailEditavel}
        />
      </View>
      
      {!nomeEditavel && (
        <TouchableOpacity style={styles.editButton} onPress={handleEditar}>
          <Text style={styles.buttonText}>Editar</Text>
        </TouchableOpacity>
      )}

      {(nomeEditavel || telefoneEditavel || emailEditavel) && (
        <View style={styles.buttonContainer}>
          <TouchableOpacity style={styles.cancelButton} onPress={handleCancelar}>
            <Text style={styles.buttonText}>Cancelar</Text>
          </TouchableOpacity>

          <TouchableOpacity style={styles.salvarButton} onPress={handleSalvar}>
            <Text style={styles.buttonText}>Salvar</Text>
          </TouchableOpacity>
        </View>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
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
  editButton: {
    backgroundColor: '#3cb371',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    marginBottom: 20,
    width: '100%',
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
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
  disabledInput: {
    backgroundColor: '#F2F2F2',
  },
  inputIcon: {
    marginRight: 10,
  },
  inputText: {
    flex: 1,
    height: 50,
    color: 'black',
  },
  buttonContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginHorizontal: 0,
  },
  cancelButton: {
    flex: 1,
    backgroundColor: 'red',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    marginRight: 10,
  },
  salvarButton: {
    flex: 1,
    backgroundColor: '#3cb371',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    marginLeft: 10,
  },
});

export default CadastroSenhaScreen;
