(ns cipher.core)

(defn to-int
  "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  "converts a number to a character"
  [number]
    (let [letter (+ number 97)]
      (char letter)))

(defn shift-letters
  "shifts each character to a factor of n"
  [char n]
    (to-char (mod (+ (to-int char) n) 26)))


(defn caesar-encrypt
  [word n]
  (apply str (mapv #(shift-letters % n) word)))

(defn caesar-decrypt
  [word n]
  (apply str (mapv #(shift-letters % (- n)) word)))

(defn is-letter [c]
  (Character/isLetter c))

(defn get-letters
  [word]
  (apply str(filterv is-letter (clojure.string/lower-case word))))

(defn count-letters
  [word letter]
  ()
  )