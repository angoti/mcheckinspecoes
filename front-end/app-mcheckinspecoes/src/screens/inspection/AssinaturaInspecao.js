import { useRef, useState } from 'react';
import { StyleSheet, View, Pressable, Text } from 'react-native';
import Signature from 'react-native-signature-canvas';

const AssinaturaInspecao = () => {
  const signatureRef = useRef();
  const [isSigned, setIsSigned] = useState(false);

  const handleSaveSignature = signatureBase64 => {
    console.log(signatureBase64);
  };

  return (
    <View style={styles.container}>
      <View style={styles.signatureContainer}>
          <Signature
            ref={signatureRef}
            onOK={handleSaveSignature}
            onEmpty={() => setIsSigned(false)}
            descriptionText="Assine na tela"
          />
          <Text style={styles.descriptionTextSign}>Assine na tela</Text>
          <Text style={styles.descriptionText}>Passo 3 de 3</Text>
      </View>
      <View style={styles.buttonContainer}>
        <Pressable style={[styles.button, styles.rotatedButton]} onPress={() => signatureRef.current.clearSignature()}>
          <View style={styles.rotatedTextContainer}>
            <Text style={styles.buttonText}>Limpar</Text>
          </View>
        </Pressable>
        <Pressable style={[styles.button, styles.rotatedButton]} onPress={() => signatureRef.current.readSignature() && navigation.navigate('CadastroInspecao')}>
          <View style={styles.rotatedTextContainer}>
            <Text style={styles.buttonText}>Assinar</Text>
          </View>
        </Pressable>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  signatureContainer: {
    width: '150%',
    height: '50%',
    alignItems: 'center',
    justifyContent: 'center',
    transform: [{ rotate: '90deg' }],
  },
  buttonContainer: {
    position: 'absolute',
    left: 0,
    top: 0,
    bottom: 0,
    justifyContent: 'center',
    alignItems: 'center',
  },
  button: {
    backgroundColor: '#3cb371',
    borderRadius: 8,
    paddingVertical: 12,
    paddingHorizontal: 24,
    marginVertical: 220,
  },
  buttonText: {
    fontSize: 16,
    color: 'white',
    fontWeight: 'bold',
    textAlign: 'center',
  },
  rotatedButton: {
    transform: [{ rotate: '-90deg' }],
  },
  rotatedTextContainer: {
    transform: [{ rotate: '180deg' }],
  },
  descriptionText: {
    color: '#3cb371',
    fontWeight: '700',
    marginTop: 16,
  },
  descriptionTextSign:{
    color: "gray",
    marginTop: 20
  }
});

export default AssinaturaInspecao;
